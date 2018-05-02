package com.xhx.ms.controller;

import com.xhx.ms.entity.Person;
import com.xhx.ms.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuhaixing on 17-11-25.
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/test")
    public String test(){
        personService.test();
        return "test Ok";
    }


    @RequestMapping("/findById")
    public Person findById(String id){
        return personService.findById(id);
    }

    @RequestMapping("/delete")
    public String delete(String id){
        personService.deleteFromCache(id);
        return "delete ok";

    }
}
