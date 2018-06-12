package com.xhx.springcloud.hystrix;

import com.xhx.springcloud.api.HelloFeign;
import org.springframework.stereotype.Component;

/**
 * xuhaixing
 * 2018/6/6 13:36
 */
@Component
public class HelloFeignHystrix implements HelloFeign {
    @Override
    public String getName(String name) {
        return "请求第三方api错误";
    }
}
