package com.xhx.springcloud.api;

import com.alibaba.fastjson.JSONObject;
import com.xhx.springcloud.hystrix.UserInfoApiHytrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * xuhaixing
 * 2018/6/16 17:19
 */
@FeignClient(value = "user-service",path = "user",fallback = UserInfoApiHytrix.class)
public interface UserInfoApi {
    @RequestMapping(value = "getUserInfo",method = RequestMethod.POST)
    JSONObject getUserInfo();
}
