package com.xhx.springboot.controller;

import com.xhx.springboot.entity.Account;
import com.xhx.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * xuhaixing
 * 2018/8/21 21:42
 **/
@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "getByName")
    public List<Account> getByName(String name){
        return accountService.getByName(name);
    }
}
