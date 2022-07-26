package com.bit.jinggong.infrastructure.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class InfrastructureApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(InfrastructureApiGatewayApplication.class, args);
    }
}
