package com.xhx.testmybatis.controller;

import com.xhx.testmybatis.entity.Person;
import com.xhx.testmybatis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuhaixing on 17-11-16.
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/get")
    public Object get(String id){
        return personService.selectPersonByPrimaryKey(id);
    }
    @RequestMapping("/add")
    public Object create(Person person){
        return personService.insertPerson(person);
    }

}
