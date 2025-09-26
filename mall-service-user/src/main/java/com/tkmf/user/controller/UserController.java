package com.tkmf.user.controller;

import com.tkmf.config.RabbitMQConfig;
import com.tkmf.constant.CookieConstant;
import com.tkmf.constant.RedisConstant;
import com.tkmf.controller.BaseController;
import com.tkmf.controller.UserControllerApi;
import com.tkmf.exception.GraceException;
import com.tkmf.grace.enums.ResponseStatusEnum;
import com.tkmf.grace.enums.UserStatus;
import com.tkmf.grace.result.GraceJSONResult;
import com.tkmf.pojo.Order;
import com.tkmf.pojo.User;
import com.tkmf.user.mapper.UserMapper;
import com.tkmf.user.service.UserService;
import com.tkmf.utils.CookieUtil;
import com.tkmf.utils.JsonUtils;
import com.tkmf.vo.RegisterLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RefreshScope
@Slf4j
@RestController
public class UserController extends BaseController implements UserControllerApi {
    @Value("${server.port}")
    private String port;

    @Value("${username1}")
    private String username1;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public GraceJSONResult findAll() {
        List<User> users = userMapper.selectAll();
        return GraceJSONResult.ok(users);
    }

    @Override
    public GraceJSONResult getMessage() {

        return null;
    }

    @Override
    public GraceJSONResult doLogin(HttpServletRequest request, HttpServletResponse response, RegisterLoginVO registerLoginVO, BindingResult bindingResult) {
        //判断字段验证是否正确
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = getErrors(bindingResult);
            return GraceJSONResult.errorMap(errors);
        }
        String username = registerLoginVO.getUsername();
        String password = registerLoginVO.getPassword();
        User userByUsername = userService.getUserByUsername(username);
        if (userByUsername == null) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.NO_AUTH);
        }
        if (!DigestUtils.md5Hex(password).equals(userByUsername.getPassword())) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.NO_AUTH);

        }
        if (userByUsername.getStatus()!= UserStatus.ACTIVE.type){
            return GraceJSONResult.errorCustom(ResponseStatusEnum.USER_FROZEN);
        }
        // TODO 设置会话与cookie信息
        // 5. 用户的分布式会话设置
        String uniqueToken = UUID.randomUUID().toString().replace("-","").trim();
        redisOperator.set(RedisConstant.REDIS_USER_TOKEN + ":" + uniqueToken, userByUsername.getOpenid());
        //6.用户userId 与token 放入cookie
        CookieUtil.setCookie(response, CookieConstant.TOKEN,uniqueToken, CookieConstant.COOKIE_MONTH);
        CookieUtil.setCookie(response,"uid",userByUsername.getOpenid(), CookieConstant.COOKIE_MONTH);
        return GraceJSONResult.ok(userByUsername);

    }

    @Override
    public GraceJSONResult userOrders(String openId) {


        //发起远程调用
        // 远程请求 orderController
        String userServerUrlExecute = "http://service-order/order/user/list?openId=" + openId;
        ResponseEntity<GraceJSONResult> responseEntity=
                restTemplate.getForEntity(userServerUrlExecute,(GraceJSONResult.class));
        GraceJSONResult bodyResult=responseEntity.getBody();
        List<Order> orderList = null;
        if(bodyResult.getStatus() == 200) {
            String userJson = JsonUtils.objectToJson(bodyResult.getData());
            orderList = JsonUtils.jsonToList(userJson, Order.class);
        }
//        return bodyResult;
        log.warn("端口号=================",port);
        System.out.println(port);
        log.warn("动态配置信息",username1);
        System.out.println(username1);

        return GraceJSONResult.ok(orderList);
    }

    @Override
    public GraceJSONResult createOrder(String openNo) {
        try{
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_ORDER,
                    "order.create",
                    openNo);
        }catch (Exception e){
            GraceException.display(ResponseStatusEnum.FAILED);
        }
        return GraceJSONResult.ok();
    }

    @Value("${hello}")
    private String name;
    @Override
    public GraceJSONResult test(String username) {
        System.out.println(name);
        return GraceJSONResult.ok(username + name);
    }


}
