package com.xhx.spring.controller;

import com.xhx.spring.domain.User;
import com.xhx.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "likeName")
    public List<User> getUserByName(String name){
        List<User> users = userService.getUserByName(name);
        return users;
    }

}
