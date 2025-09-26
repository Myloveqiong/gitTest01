package com.tkmf;
// 扫描指定包下所有相关组件

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@ComponentScan(basePackages = {"com.tkmf","org.n3r.idworker","com.tkmf.user.service"})
// 扫描mybatis通用mapper所在包
@MapperScan(basePackages = "com.tkmf.user.mapper")

@SpringBootApplication
public class UserApplication {
    static {
        //修复引入nacos config依赖导致和本地配置的logback 冲突的问题
        System.setProperty("nacos.logging.default.config.enabled", "false");
    }

    public static void main(String[] args) {

        SpringApplication.run(UserApplication.class, args);
    }
}
