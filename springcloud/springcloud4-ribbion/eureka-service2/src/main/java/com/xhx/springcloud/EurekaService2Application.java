package com.xhx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   //标记为eureka client
public class EurekaService2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaService2Application.class, args);
    }
}
