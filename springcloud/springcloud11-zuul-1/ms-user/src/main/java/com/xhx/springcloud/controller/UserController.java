package com.xhx.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * xuhaixing
 * 2018/8/12 22:09
 **/
@RestController
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "getUserInfo",method = RequestMethod.POST)
    public Map getUserInfo(@RequestParam("id") String id){
        Map<String,String> user = new HashMap<>();
        user.put("id",id);
        user.put("name","xxxxx");
        user.put("age","16");
        return user;
    }
}
