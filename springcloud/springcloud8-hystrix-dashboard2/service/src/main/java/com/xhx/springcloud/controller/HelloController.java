package com.xhx.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * xuhaixing
 * 2018/6/7 15:04
 */
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @RequestMapping(value = "getWord")
    public String getWord(@RequestParam(value = "name") String name){
        return name;
    }
}
