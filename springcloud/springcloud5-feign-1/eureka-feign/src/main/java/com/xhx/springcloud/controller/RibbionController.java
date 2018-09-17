package com.xhx.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.xhx.springcloud.api.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * xuhaixing
 * 2018/6/3 16:27
 */
@RestController
public class RibbionController {

    @Autowired
    private HelloFeign helloFeign;

    @RequestMapping(value = "getName")
    public String getName(String name){
        return helloFeign.getName(name);
    }

    @RequestMapping(value = "getUser")
    public Map getUser(){
        Map<String,Object> user = new HashMap<>();
        user.put("id","1");
        user.put("name","xuhaixing");
        Map user1 = helloFeign.getUser(user);
        return user1;
    }

    @RequestMapping(value = "getUser2")
    public Map getUser2(){
        Map<String,String> user = new HashMap<>();
        user.put("id","1");
        user.put("name","xuhaixing");
        Map user1 = helloFeign.getUser(user.get("id"),user.get("name"));
        return user1;
    }
}

