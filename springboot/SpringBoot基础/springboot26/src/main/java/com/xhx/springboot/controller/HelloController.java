package com.xhx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * xuhaixing
 * 2018/8/18 22:10
 *
 * thymeleaf3.0之前 html标签需要闭合，之后不需要
 **/
@Controller
@RequestMapping(value = "templates")
public class HelloController {

    @RequestMapping("hello")
    public String getHello(Map<String,Object> map){
        map.put("name","大大");
        return "hello";
    }
}
