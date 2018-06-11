package com.xhx.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.xhx.springcloud.api.HelloApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * xuhaixing
 * 2018/6/7 15:44
 */
@RestController
@RequestMapping(value = "userInfo")
public class UserController {

    @Autowired
    private HelloApi helloApi;

    @RequestMapping(value = "getName",method = RequestMethod.POST)
    public String getName(@RequestParam(value = "name") String name){
        return helloApi.getWord(name);
    }
}
