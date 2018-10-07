package com.xhx.spring.config;

import com.xhx.spring.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * xuhaixing
 * 2018/9/28 22:31
 **/
@Configuration
public class UserConfig {

    @Bean
    public User user(){
        return new User("fdsf-df-32-fa-g","xu",25);
    }
}
