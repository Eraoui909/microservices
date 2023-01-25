package com.example.apigateway.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.util.logging.Logger;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator routers(RouteLocatorBuilder routeLocatorBuilder){


        return routeLocatorBuilder.routes()
                .route(
                        r -> r.path("/currency-conversion-feign/**")
                                .uri("lb://currency-conversion/**")
                )
                .route(
                        r -> r.path("/get")
                                .uri("http://httpbin.org:80")
                )
                .build();
    }
}
