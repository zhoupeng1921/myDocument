package com.xhx.springcloud.api;

import com.xhx.springcloud.hystrix.HelloFeignHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * xuhaixing
 * 2018/6/5 16:51
 */
@FeignClient(value = "EUREKA-SERVICE",path = "hello", fallback =HelloFeignHystrix.class)
public interface HelloFeign {

    @RequestMapping(value = "getName")
    public String getName(@RequestParam("name") String name);//@RequestParam 必须加上，否则可能会接不到参数
}
