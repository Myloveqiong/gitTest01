package com.tkmf.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

@Slf4j
@Component
public class MyFilter implements GlobalFilter, Ordered {

    private static final Integer user = 1234567;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        InetSocketAddress remoteAddress = exchange.getRequest().getRemoteAddress();
        if (remoteAddress != null) {
            String host = remoteAddress.getHostString(); // IP 地址
            int port = remoteAddress.getPort();          // 端口
            System.out.println("请求来源 IP: " + host + "，端口: " + port);
        }
        //判断header中是否有token
        ServerHttpRequest request = exchange.getRequest();
        //获取端口号和具体的域名
        String rawPath = request.getURI().getRawPath();
        log.info("request path: {}", rawPath);
        //获取用户请求头中的参数
        String user1 = request.getHeaders().getFirst("openId");
        log.info("openId: {}", user1);
        //进行判断
        if (user1 ==null || !user1.equals(user.toString())) {

            //返回状态
            exchange.getResponse().setStatusCode(HttpStatus.BAD_GATEWAY);
            log.warn("没有通过过滤器");
            //禁止通信
            return exchange.getResponse().setComplete();
        }
        //通过过滤放行
        return chain.filter(exchange);

    }

    //过滤器的顺序数值越小优先级越高

    @Override
    public int getOrder() {
        //优先级最高
        return -1;
    }
}
