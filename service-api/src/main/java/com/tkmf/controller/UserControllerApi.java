package com.tkmf.controller;

import com.tkmf.grace.result.GraceJSONResult;
import com.tkmf.vo.RegisterLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "用户服务",tags = {"用户功能Controller"})
@RequestMapping("/user")
public interface UserControllerApi {



    @ApiOperation(value = "findAll方法",notes = "查询用户所有信息",httpMethod = "GET")
    @GetMapping("/findAll")
    GraceJSONResult findAll();

    @ApiOperation(value = "获取验证码",notes = "用户提交手机号发送验证码给用户",httpMethod = "GET")
    @GetMapping("/getMessage")
    GraceJSONResult getMessage();

    @ApiOperation(value = "登录方法",notes = "提交用户名和密码然后进行登录",httpMethod = "POST")
    @PostMapping("/doLogin")
    GraceJSONResult doLogin(HttpServletRequest request, HttpServletResponse response,
                            @RequestBody RegisterLoginVO registerLoginVO, BindingResult bindingResult);

    @ApiOperation(value = "获取订单方法",notes = "根据用户的openId获取用户的订单信息",httpMethod = "GET")
    @GetMapping("/orders")
    GraceJSONResult userOrders(@RequestParam String openId);

    @ApiOperation(value = "发送消息到消息队列",notes = "rabbitmq",httpMethod = "GET")
    @GetMapping("/createOrder")
    GraceJSONResult createOrder(@RequestParam String openNo);

    @ApiOperation(value = "nacos配置测试",notes = "",httpMethod = "GET")
    @GetMapping("/test")
    GraceJSONResult test(@RequestParam String username);

}

