package com.xhx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * xuhaixing
 * 2018/6/3 16:18
 */
@RestController
@RequestMapping(value = "hello")
@RefreshScope
public class HelloController {

    @Value("${user.name}")
    private String name;

    @RequestMapping(value = "getName")
    public String getName(){
        return name;
    }
}
