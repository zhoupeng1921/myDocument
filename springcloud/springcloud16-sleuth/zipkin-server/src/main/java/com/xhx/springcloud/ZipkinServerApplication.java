package com.xhx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

/**
 * xuhaixing
 * 2018/6/16 18:32
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer //已经没这个包了，不能用了，看博客
public class ZipkinServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class,args);
    }
}
