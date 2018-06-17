package com.xhx.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * xuhaixing
 * 2018/6/16 17:09
 */
@RestController
@RequestMapping(value = "user")
public class UserController {


    @RequestMapping(value = "getUserInfo",method = RequestMethod.POST)
    public Map<String, String> getUserInfo(){
        Map<String,String> user = new HashMap<>();
        user.put("name","xuhaixing");
        user.put("gender","man");
        return user;
    }
}
