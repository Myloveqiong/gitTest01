package com.tkmf.controller;

import com.tkmf.grace.result.GraceJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Api(value = "用户服务",tags = {"用户功能Controller"})
@RequestMapping("/user")
public interface UserControllerApi {
    @ApiOperation(value = "findAll方法",notes = "查询用户所有信息",httpMethod = "GET")
    @GetMapping("/findAll")
    GraceJSONResult findAll();

}

