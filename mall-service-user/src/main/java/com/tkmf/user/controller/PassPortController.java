package com.tkmf.user.controller;

import com.tkmf.controller.BaseController;
import com.tkmf.controller.PassPortControllerApi;
import com.tkmf.grace.result.GraceJSONResult;
import com.tkmf.utils.IPUtil;
import com.tkmf.utils.RedisOperator;
import com.tkmf.utils.SMSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PassPortController extends BaseController implements PassPortControllerApi {

    @Autowired
    SMSUtils smsUtils;

    @Override
    public GraceJSONResult getSMSCode(String mobile, HttpServletRequest request) {

        //根据用户的ip限制60秒之内只能发送一次验证码
        String requestIp = IPUtil.getRequestIp(request);
        //生成验证码
        String code =  (int) ((Math.random()*9+1)*100000) + "";
//        String code = String.valueOf((int) (Math.random()*9+1)*100000);

        boolean b = redisOperator.setnx60s(MOBILE_SMSCODE + requestIp, requestIp);

        //把验证码放进redis,后面验证登录的时候会用
        redisOperator.set(MOBILE_SMSCODE+mobile,code);

        //发送短信信息
//        smsUtils.sendSMS(mobile,code);

        if (b){
            return GraceJSONResult.ok(code) ;
        }else {
            return GraceJSONResult.error();
        }
    }
}
