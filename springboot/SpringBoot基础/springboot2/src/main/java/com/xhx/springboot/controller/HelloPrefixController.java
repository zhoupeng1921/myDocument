package com.xhx.springboot.controller;

import com.xhx.springboot.config.UserPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * made by xuhaixing
 * 18-4-8 下午10:01
 */
@RestController
@EnableConfigurationProperties({UserPrefix.class})  //激活配置,测试了一下,也可以没有
public class HelloPrefixController {

    @Autowired
    private UserPrefix userPrefix;

    @RequestMapping(value = "/getUserPrefix")
    public String getUserPrefix() {
        return userPrefix.getName() + " " + userPrefix.getSex() + " " + userPrefix.getAge();
    }

}
