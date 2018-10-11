package com.xhx.spring.controller;


import com.xhx.spring.entity.User;
import com.xhx.spring.interfaces.New;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {

    /**
     * 加分组的只验证分组的注解
     * @param user
     * @return
     */
    @RequestMapping("add")
    public User add(@Validated(value = {New.class}) @RequestBody User user){
        return user;
    }

    /**
     * 只验证没有分组的注解
     * @param user
     * @return
     */
    @RequestMapping("add2")
    public User add2(@Validated @RequestBody User user){
        return user;
    }
}
