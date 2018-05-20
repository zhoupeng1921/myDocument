package com.xhx.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * xuhaixing
 * 2018/5/20 22:47
 */
@RestController
@RequestMapping(value = "test")
public class HelloController {

    @RequestMapping(value = "hello")
    public String helloWorld(){
        return "hello world";
    }
}
