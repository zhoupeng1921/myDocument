package com.xhx.spring.config;

import com.xhx.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class UserConfig {


    @Bean(name = "user1")
    public User getUser1(){
        return new User("a23-fsa-ef","xu",25);
    }

    @Primary
    @Bean(name = "user2")
    public User user2(){
        return new User("brr-dfa-874","haixing",25);
    }



}
