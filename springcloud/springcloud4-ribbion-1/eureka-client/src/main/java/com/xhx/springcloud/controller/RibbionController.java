package com.xhx.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * xuhaixing
 * 2018/6/3 16:27
 */
@RestController
public class RibbionController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient balancerClient;

    @RequestMapping(value = "getName")
    public String getName(String name){
        return restTemplate.getForObject("http://eureka-service/hello/getName?name="+name,String.class);
    }

    @RequestMapping(value = "getName2")
    public String getName2(String name){
        return restTemplate.getForObject("http://eureka-service2/hello/getName?name="+name,String.class);
    }

    @RequestMapping(value = "balancer")
    public String balancerInstance(){
        ServiceInstance serviceInstance = this.balancerClient.choose("eureka-service");
        URI uri = URI.create(String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()));
        return uri.toString();
    }
}

