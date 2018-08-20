package com.xhx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * xuhaixing
 * 2018/8/20 21:33
 **/
@Controller
public class HelloController {

    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }
}
