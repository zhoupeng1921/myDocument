package com.xhx.springboot.controller;

import com.xhx.springboot.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * made by xuhaixing
 * 18-4-8 下午9:48
 */
@RestController
public class HelloController {

    @Autowired
    private User user;

    @RequestMapping(value = "/getUser")
    public String getUser(){
        return  user.getName()+" "+user.getSex()+" "+user.getAge();
    }
}
