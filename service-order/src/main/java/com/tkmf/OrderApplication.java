package com.tkmf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@ComponentScan(basePackages = {"com.tkmf","org.n3r.idworker"})
// 扫描mybatis通用mapper所在包
@MapperScan(basePackages = "com.tkmf.order.mapper")

@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
