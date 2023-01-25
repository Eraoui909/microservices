package com.example.apigateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
public class LoggerFilter implements GlobalFilter {

    Logger logger =  LoggerFactory.getLogger(LoggerFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("-> the path  = {}", exchange.getRequest().getPath());
        logger.info("-> the global path  = {}", exchange.getRequest().getRemoteAddress());
        return chain.filter(exchange);
    }
}
