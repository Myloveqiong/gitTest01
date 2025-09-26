package com.tkmf.order.controller;

import com.tkmf.controller.BaseController;
import com.tkmf.exception.GraceException;
import com.tkmf.grace.enums.ResponseStatusEnum;
import com.tkmf.grace.result.GraceJSONResult;
import com.tkmf.order.service.OrderService;
import com.tkmf.pojo.Order;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController extends BaseController implements com.tkmf.controller.OrderController {

    @Autowired
    private OrderService orderService;

    @Override
    public GraceJSONResult orderList(String openId) {

        if (openId == null || "".equals(openId)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.USER_STATUS_ERROR);
        }
        List<Order> orderList = orderService.getOrderList(openId);
        if (orderList == null || orderList.isEmpty()) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.FAILED);
        }
        return GraceJSONResult.ok(orderList);
    }

    @Override
    public GraceJSONResult shopReceive(String orderNo) {
        if (orderNo == null || "".equals(orderNo)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.FAILED);
        }
        Order order = orderService.updateOrderStatus(orderNo);
        return GraceJSONResult.ok(order);
    }
}
