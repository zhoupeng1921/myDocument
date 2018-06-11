package com.xhx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * xuhaixing
 * 2018/6/7 14:22
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableEurekaClient
public class HystrixdashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixdashboardApplication.class, args);
    }
}
