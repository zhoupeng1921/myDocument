package com.xhx.springboot.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("hello")
public class HelloController {

    @PostMapping(value = "hello")
    public Map<String,String> getHello(){
        Map<String,String> map = new HashMap<>();
        map.put("hello","hello word");
        return map;
    }

}
