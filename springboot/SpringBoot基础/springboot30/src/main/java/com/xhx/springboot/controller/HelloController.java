package com.xhx.springboot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @RequestMapping(value = "getName")
    public String getName(@RequestParam("name") String name) {
        return "姓名是" + name;
    }

    @RequestMapping(value = "getUser")
    public Map getUser(@RequestParam("id") String id) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "小小");
        map.put("id", id);
        return map;
    }

    @RequestMapping(value = "getAge")
    public int getAge(@RequestParam("id") String id) {
        if (id.equals("1")) {
            throw new NullPointerException();
        }
        return 18;
    }
}
