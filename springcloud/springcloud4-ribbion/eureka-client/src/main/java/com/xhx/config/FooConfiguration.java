package com.xhx.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * xuhaixing
 * 2018/9/3 20:09
 *
 *  不放在ComponentScan下，否则会变成全局的，如果对单个微服务进行控制，就放在扫描的外面
 *
 **/
@Configuration
public class FooConfiguration {

    @Bean
    public IRule ribbonRule(IClientConfig config){
        return new RandomRule();
    }
}
