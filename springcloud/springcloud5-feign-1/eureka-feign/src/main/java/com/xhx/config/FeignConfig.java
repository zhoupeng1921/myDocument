package com.xhx.config;

import feign.Contract;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * xuhaixing
 * 2018/9/17 22:45
 **/
@Configuration
public class FeignConfig {

    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
        //默认 SpringMvcContract
    }
}
