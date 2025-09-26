package com.tkmf.controller;

import com.tkmf.grace.result.GraceJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "用户订单服务",tags = {"用户订单功能OrderController"})
@RequestMapping("/order")
public interface OrderController {
    @ApiOperation(value = "orderList方法",notes = "查询用户订单所有信息",httpMethod = "GET")
    @GetMapping("/user/list")
    public GraceJSONResult orderList(String openId);
    //商家收到信息改变状态
    @ApiOperation(value = "商家收到信息改变状态",notes = "商家收到信息改变状态",httpMethod = "GET")
    @GetMapping("/shop/receive")
    public GraceJSONResult shopReceive(String orderNo);




}
