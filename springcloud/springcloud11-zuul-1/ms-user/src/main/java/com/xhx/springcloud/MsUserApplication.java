package com.xhx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * xuhaixing
 * 2018/8/12 22:08
 **/
@SpringBootApplication
@EnableEurekaClient
public class MsUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsUserApplication.class,args);
    }
}
