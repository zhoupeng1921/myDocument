package com.xhx.springcloud.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * xuhaixing
 * 2018/6/5 16:51
 */
@FeignClient(value = "EUREKA-SERVICE",path = "hello")
public interface HelloFeign {

    @RequestMapping(value = "getName")
    public String getName(@RequestParam(value = "name") String name);//@RequestParam与value 必须加上，否则会接不到参数


}
