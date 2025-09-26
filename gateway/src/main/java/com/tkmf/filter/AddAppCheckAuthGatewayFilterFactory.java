package com.tkmf.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//过滤器工厂类的名字去掉 GatewayFilterFactory 后缀，得到过滤器的名称。
@Component
public class AddAppCheckAuthGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {

    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return new GatewayFilter(){

            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                exchange.getRequest().mutate().header(config.getName(),config.getValue());
                return chain.filter(exchange);
            }
        };
    }
}