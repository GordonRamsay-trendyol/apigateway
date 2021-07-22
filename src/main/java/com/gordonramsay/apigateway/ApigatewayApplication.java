package com.gordonramsay.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApigatewayApplication {
    private static final String USER_SERVER_URI = "http://user-ms:8889";
    private static final String PRODUCT_SERVER_URI = "http://product-ms:8888";

    public static void main(String[] args) {
        SpringApplication.run(ApigatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user", r -> r.path("/users").uri(USER_SERVER_URI))
                .route("product", r -> r.path("/products").uri(PRODUCT_SERVER_URI))
                .build();
    }

}

