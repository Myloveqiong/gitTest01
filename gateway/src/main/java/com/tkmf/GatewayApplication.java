package com.tkmf;


import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
    @Bean
    public IRule myRule() {
        return new NacosRule();
    }
    public static void main(String[] args) {
       SpringApplication.run(GatewayApplication.class, args);
    }
}
