package com.xhx.spring.config;

import com.xhx.spring.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.beans.PersistenceDelegate;

@Configuration
public class ScopeConfig {

    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)   //单例  多例
    @Bean
    @Lazy //是否在用到的时候再初始化
    public Person getPerson(){
        System.out.println("初始化。。");
        return new Person("xu",25);
    }

//    @Autowired
//    private Person person1;
    @Autowired
    @Lazy //是否在用到的时候再注入
    private Person person2;
}
