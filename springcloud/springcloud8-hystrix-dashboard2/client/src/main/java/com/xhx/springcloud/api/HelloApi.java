package com.xhx.springcloud.api;

import com.xhx.springcloud.hystrix.HelloHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * xuhaixing
 * 2018/6/7 15:28
 */
@FeignClient(value = "APPLICATION-SERVICE",path = "hello",fallback =HelloHystrix.class)
public interface HelloApi {
    @RequestMapping(value = "getWord")
    String getWord(@RequestParam(value = "name") String name);
}
