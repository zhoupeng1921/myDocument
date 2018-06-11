package com.xhx.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.xhx.springcloud.api.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * xuhaixing
 * 2018/6/3 16:27
 */
@RestController
@EnableEurekaClient
@EnableHystrix
public class RibbionController {

    @Autowired
    private HelloFeign helloFeign;

    @RequestMapping(value = "getName")
    public String getName(String name){
        return helloFeign.getName(name);
    }
}

