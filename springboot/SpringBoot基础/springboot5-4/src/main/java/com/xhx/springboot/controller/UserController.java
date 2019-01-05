package com.xhx.springboot.controller;


import com.xhx.springboot.entity.User;
import com.xhx.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getById")
    public User getById(Integer id) {
        return userService.getUserWithAccount(id);
    }
    @GetMapping(value = "/getList")
    public List<User> getById() {
        return userService.getUserWithAccountList();
    }
}
