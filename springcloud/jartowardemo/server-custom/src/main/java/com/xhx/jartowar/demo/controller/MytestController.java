package com.xhx.jartowar.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MytestController {


    @RequestMapping(value="getTest", method= RequestMethod.POST)
    public Object getTest(){
        Map<String,String> map = new HashMap<>();
        return map;
    }
}
