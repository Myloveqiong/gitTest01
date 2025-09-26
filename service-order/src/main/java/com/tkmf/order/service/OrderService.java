package com.tkmf.order.service;

import com.tkmf.pojo.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrderList(String openId);

    //修改订单的状态
    Order updateOrderStatus(String orderNo);

    //根据订单号查询订单信息
    Order getOrder(String orderNo);



}

