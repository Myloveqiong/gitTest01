package com.tkmf.user.service;

import com.tkmf.pojo.Order;
import com.tkmf.pojo.User;

public interface UserService {

    //判断用户是否存在
   User getUserByUsername(String username);
   //创建订单
//    Order createOrder(Order order);
}
