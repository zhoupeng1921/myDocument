package com.xhx.springboot.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private String age;

    @RequestMapping(value = "/hello",method = {RequestMethod.GET,RequestMethod.POST})
    public String index(){
        return "spring boot my first SpringBoot";
    }

    @RequestMapping(value = "/getMyInfo")
    public String getMyInfo(){
        return name+"  "+age;
    }

}
