package com.tkmf.rabbit;

import com.tkmf.config.RabbitMQConfig;
import com.tkmf.exception.GraceException;
import com.tkmf.grace.enums.ResponseStatusEnum;
import com.tkmf.grace.result.GraceJSONResult;
import com.tkmf.pojo.Order;
import com.tkmf.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Slf4j
@Component
public class RabbitMQConsumer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @RabbitListener(queues = {RabbitMQConfig.QUEUE_ORDER})
    public void watchQueue(String reload, Message message) {
        log.info("reload:{}", reload);
        log.info("message:{}", message);
        String key = message.getMessageProperties().getReceivedRoutingKey();
        log.info("key:{}", key);
        //根据要做的服务进行判断
        if (key.equals("order.create")) {
            log.info("消费消息完成，发送消息给用户告诉用户商家已经接单");
            Order order = receiveOrdeer(reload);
            if (order != null) {
                log.warn("发送给用户已结单的消息");
                return;
            }
            log.warn("发送消息失败");
        } else {
            log.info("不符合规则");
        }

    }

    private Order receiveOrdeer(String orderNo) {
        if (orderNo == null || "".equals(orderNo)) {
            GraceException.display(ResponseStatusEnum.FAILED);
        }

        //发送远程请求到service-order
        // 远程请求 orderController
        String orderServerUrlExecute = "http://service-order/order/shop/receive?orderNo=" + orderNo;
        ResponseEntity<GraceJSONResult> responseEntity=
                restTemplate.getForEntity(orderServerUrlExecute,(GraceJSONResult.class));
        GraceJSONResult bodyResult=responseEntity.getBody();
        Order order= null;
        if(bodyResult.getStatus() == 200) {
            String userJson = JsonUtils.objectToJson(bodyResult.getData());
            order = JsonUtils.jsonToPojo(userJson, Order.class);
        }
        return order;
    }
}