package com.xhx.springcloud.config;

import com.xhx.config.FooConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * xuhaixing
 * 2018/9/3 19:53
 **/
@Configuration
@RibbonClient(name = "eureka-service2",configuration = FooConfiguration.class)
public class TestConfiguration {
}
