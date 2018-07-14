package com.xhx.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * xuhaixing
 * 2018/7/13 20:19
 **/

@RestController
public class TestController {

    @RequestMapping(value = "test1")
    public Map testWar1(){
        Map<String,String> map = new HashMap<>();
        map.put("result","success");
        map.put("code","200");
        map.put("method","test1");
        return map;
    }
    @RequestMapping(value = "test2")
    public Map testWar2(){
        Map<String,String> map = new HashMap<>();
        map.put("result","success");
        map.put("code","200");
        map.put("method","test2");
        return map;
    }
    @RequestMapping(value = "test3")
    public Map testWar3(){
        Map<String,String> map = new HashMap<>();
        map.put("result","success");
        map.put("code","200");
        map.put("method","test3");
        return map;
    }
}
