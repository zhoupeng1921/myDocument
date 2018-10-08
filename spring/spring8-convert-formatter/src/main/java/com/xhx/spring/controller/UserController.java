package com.xhx.spring.controller;/*
 * xuhai
 * 2018/10/8 22:21
 */

import com.xhx.spring.enums.GenderEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "getGender")
    public Object getGender(@RequestParam(value = "genderEnum") GenderEnum genderEnum){
        return genderEnum;
    }
}
