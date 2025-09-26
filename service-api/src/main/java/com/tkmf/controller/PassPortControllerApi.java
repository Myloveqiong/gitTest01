package com.tkmf.controller;

import com.tkmf.grace.result.GraceJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Api(value = "用户服务",tags = {"用户功能Controller"})
@RequestMapping("/user")
public interface PassPortControllerApi {
    @ApiOperation(value = "获取验证码",notes = "用户提交手机号发送验证码给用户",httpMethod = "GET")
    @GetMapping("/getSMSCode")
    public GraceJSONResult getSMSCode(String mobile, HttpServletRequest request);

}
