package com.xhx.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xhx.springboot.vo.PersonVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * xuhaixing
 * 2018/5/19 21:44
 */
@RestController
@RequestMapping(value = "person")
public class PersonController {

    @RequestMapping("save")
    public String savePerson(@Valid PersonVO personVO) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(personVO));
        return  "success";
    }
}
