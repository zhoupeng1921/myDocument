package com.xhx.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * xuhaixing
 * 2018/6/3 16:27
 */
@RestController
public class RibbionController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "getName")
    public String getName(String name){
        return restTemplate.getForObject("http://EUREKA-SERVICE/hello/getName?name="+name,String.class);
    }
}

