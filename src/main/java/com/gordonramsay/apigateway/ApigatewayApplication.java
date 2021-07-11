package com.gordonramsay.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApigatewayApplication {
    private static final String USER_SERVER_URI = "http://localhost:8889";
    private static final String PRODUCT_SERVER_URI = "http://localhost:8888";

    public static void main(String[] args) {
        SpringApplication.run(ApigatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user", r -> r.path("/api/users").filters(f -> f.stripPrefix(1)).uri(USER_SERVER_URI))
                .route("product", r -> r.path("/api/products").filters(f -> f.stripPrefix(1)).uri(PRODUCT_SERVER_URI))
                .build();
    }
}
