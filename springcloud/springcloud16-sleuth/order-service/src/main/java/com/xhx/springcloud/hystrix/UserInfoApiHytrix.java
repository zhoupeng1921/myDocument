package com.xhx.springcloud.hystrix;

import com.alibaba.fastjson.JSONObject;
import com.xhx.springcloud.api.UserInfoApi;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * xuhaixing
 * 2018/6/16 17:20
 */
@Component
public class UserInfoApiHytrix implements UserInfoApi {
    @Override
    public JSONObject getUserInfo() {
        return null;
    }
}
