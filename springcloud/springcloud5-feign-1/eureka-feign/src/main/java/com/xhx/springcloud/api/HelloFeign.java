package com.xhx.springcloud.api;

import com.xhx.config.FeignConfig;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * xuhaixing
 * 2018/6/5 16:51
 */
@FeignClient(value = "EUREKA-SERVICE",path = "hello",configuration = FeignConfig.class)
public interface HelloFeign {

    @RequestLine(value = "GET getName")
    public String getName(@Param(value = "name") String name);

}
