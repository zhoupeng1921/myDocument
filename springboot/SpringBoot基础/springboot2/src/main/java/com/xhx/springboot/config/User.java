package com.xhx.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * made by xuhaixing
 * 18-4-8 下午9:01
 */


@Configuration  //证明这是一个配置类
@PropertySource(value = {"classpath:test.properties"},ignoreResourceNotFound = true)//可以放多个,{}里面用,分开
public class User {

    //可以不用set方法,直接就能注入,属于注入
    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private int age;

    @Value("${my.sex}")
    private String sex;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

}
