package com.tkmf.controller;

import com.tkmf.grace.result.GraceJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "店铺服务",tags = {"店铺功能Controller"})
@RequestMapping("/shop")
public interface ShopController {
    @ApiOperation(value = "消费消息方法",notes = "shop",httpMethod = "GET")
    @GetMapping("/test")
    public GraceJSONResult hello();
}
