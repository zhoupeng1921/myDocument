package com.xhx.springboot.controller;

import com.xhx.springboot.entity.User;
import com.xhx.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/5/2 9:55
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public int add(@RequestBody User user) {
        return userService.add(user);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public int update(@RequestBody User user) {
        return userService.update(user);
    }


    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public int delete(@RequestParam int id) {
        return userService.delete(id);
    }

    @RequestMapping(value = "findById", method = RequestMethod.POST)
    public User findById(@RequestParam int id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "findList", method = RequestMethod.POST)
    public List<User> findList() {
        return userService.findList();
    }

}
