package com.tkmf.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_ORDER = "mall_order";
    public static final String QUEUE_ORDER= "mall_queue";
    //创建交换机
    @Bean(EXCHANGE_ORDER)
    public Exchange exchange() {
        return ExchangeBuilder
                .topicExchange(EXCHANGE_ORDER)
                .durable(true).build();//声明这是一个持久化的交换机
    }

    //创建队列
    @Bean(QUEUE_ORDER)
    public Queue queue() {
        return new Queue(QUEUE_ORDER);
    }

    //进行绑定
    @Bean
    public Binding binding(@Qualifier(EXCHANGE_ORDER) Exchange exchange,
                           @Qualifier(QUEUE_ORDER) Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("order.*")
                .noargs();
    }



}
