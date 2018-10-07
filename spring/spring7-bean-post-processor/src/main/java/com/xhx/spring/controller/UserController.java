package com.xhx.spring.controller;

import com.xhx.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * xuhaixing
 * 2018/9/28 22:32
 **/
@RestController
@RequestMapping(name = "user")
public class UserController {
    @Autowired
    private User user;

    @RequestMapping(name = "getUser")
    public User getUser(){
        return user;
    }
}
