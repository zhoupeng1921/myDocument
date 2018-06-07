package com.xhx.springcloud.hystrix;

import com.xhx.springcloud.api.HelloApi;
import org.springframework.stereotype.Component;

/**
 * xuhaixing
 * 2018/6/7 15:37
 */
@Component
public class HelloHystrix implements HelloApi {
    @Override
    public String getWord(String name) {
        return "调用第三方api错误";
    }
}
