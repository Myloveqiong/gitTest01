package com.tkmf.order.service.impl;

import com.tkmf.exception.GraceException;
import com.tkmf.grace.enums.OrderStatusEnum;
import com.tkmf.grace.enums.ResponseStatusEnum;
import com.tkmf.order.mapper.OrderMapper;
import com.tkmf.order.service.OrderService;
import com.tkmf.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> getOrderList(String openId) {
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userOpenid", openId);
        List<Order> orders = orderMapper.selectByExample(example);
        return orders;
    }



    @Override
    public Order updateOrderStatus(String orderNo) {
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setOrderStatus(OrderStatusEnum.NO_SEND.getStatus());
        int i = orderMapper.updateByPrimaryKeySelective(order);
        if (i != 1) {
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
        BeanUtils.copyProperties(getOrder(orderNo), order);
        return order;
    }

    @Override
    public Order getOrder(String orderNo) {
        Order order = orderMapper.selectByPrimaryKey(orderNo);
        if (order == null) {
            log.warn("找不到该订单");
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
        return order;
    }
}
