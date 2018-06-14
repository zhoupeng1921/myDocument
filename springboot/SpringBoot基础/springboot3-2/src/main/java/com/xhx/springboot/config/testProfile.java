package com.xhx.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import sun.tools.jar.CommandLine;

/**
 * made by xuhaixing
 * 18-4-8 下午10:46
 */
@Configuration
public class testProfile {

    @Value("${server.port}")
    private String port;


    @Profile("!dev") //可以用取反操作符,也可以用多个参数
    @Bean
    public CommandLine testPort() {
        System.out.println("--------------" + port);
        return new CommandLine();
    }
}
