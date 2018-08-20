package com.xhx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * xuhaixing
 * 2018/8/19 19:34
 *
 * 可同时使用多个模板引擎，thymeleafe,freemarker
 **/
@Controller
@RequestMapping("/templates")
public class TemplatesController {

    @RequestMapping(value = "hello")
    public String helloFtl(Map<String,Object> map){
        map.put("name","小小");
        return "hello";
    }
}
