package com.xhx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * xuhaixing
 * 2018/6/3 16:18
 */
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "getName")
    public String getName(String name){
        return name+port;
    }
}
