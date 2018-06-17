package com.xhx.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.xhx.springcloud.api.UserInfoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * xuhaixing
 * 2018/6/16 17:19
 */
@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    private UserInfoApi userInfoApi;

    @RequestMapping(value = "getUserOrder",method = RequestMethod.POST)
    public JSONObject getUserOrder(){
        JSONObject userInfo = userInfoApi.getUserInfo();
        Optional.ofNullable(userInfo).ifPresent(user->user.put("orderMoney",999));
        return userInfo;
    }
}
