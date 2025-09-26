package com.tkmf.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LoggingGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        // 请求前逻辑 (Pre)
        String method = exchange.getRequest().getMethodValue();
        String path = exchange.getRequest().getURI().getPath();
        String ip = exchange.getRequest().getRemoteAddress() != null
                ? exchange.getRequest().getRemoteAddress().getAddress().getHostAddress()
                : "unknown";

        log.info("[请求日志] 请求开始 -> method: {}, path: {}, ip: {}", method, path, ip);

        long startTime = System.currentTimeMillis();
        exchange.getAttributes().put("startTime", startTime);

        // 请求后逻辑 (Post)
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long start = exchange.getAttribute("startTime");
            if (start != null) {
                long duration = System.currentTimeMillis() - start;
                log.info("[请求日志] 请求结束 -> method: {}, path: {}, ip: {}, 耗时: {}ms",
                        method, path, ip, duration);
            }
        }));
    }

    @Override
    public int getOrder() {
        return -2; // 优先级高
    }
}
