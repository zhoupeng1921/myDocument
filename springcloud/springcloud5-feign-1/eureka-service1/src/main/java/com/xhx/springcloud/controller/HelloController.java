package com.xhx.springcloud.controller;

import com.xhx.springcloud.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * xuhaixing
 * 2018/6/3 16:18
 */
@RestController
@RequestMapping(value = "hello")
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Value(value = "${server.port}")
    private String port;

    @RequestMapping(value = "getName")
    public String getName(@RequestParam("name")  String name){
        return name+port;
    }

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    public User getUser(User user){
        logger.info("请求了getUser");
        return user;
    }
}
