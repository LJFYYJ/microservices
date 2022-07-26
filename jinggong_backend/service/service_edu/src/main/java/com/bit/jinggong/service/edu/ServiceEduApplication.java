package com.bit.jinggong.service.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//便于扫描service_base下面的内容
@ComponentScan({"com.bit.jinggong"})
public class ServiceEduApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceEduApplication.class, args);
    }
}
