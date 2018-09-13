package com.xhx.springboot.controller;

import com.xhx.springboot.entity.User;
import com.xhx.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhaixing
 * @date 2018/5/2 9:55
 */
@RestController
@RequestMapping("account")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public int add(@RequestBody User user) {
        return userService.insert(user);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public int update(@RequestBody User user) {
        return userService.updateByPrimaryKey(user);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public int delete(@RequestBody int id) {
        return userService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "findById", method = RequestMethod.POST)
    public User findById(@RequestBody int id) {
        return userService.selectByPrimaryKey(id);
    }

}
