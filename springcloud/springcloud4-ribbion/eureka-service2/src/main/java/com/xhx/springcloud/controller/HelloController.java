package com.xhx.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * xuhaixing
 * 2018/6/3 16:18
 */
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @RequestMapping(value = "getName")
    public String getName(String name){
        return name+2;
    }
}
