package com.xhx.springboot.controller;

import com.xhx.springboot.entity.Account;
import com.xhx.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/5/4 9:26
 */

@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "save")
    public int save(@RequestBody Account account) {
        accountService.save(account);
        return 1;
    }

    @RequestMapping(value = "findAll")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @RequestMapping(value = "findById")
    public Account findById(String id) {
        return accountService.findById(id);
    }

    @RequestMapping(value = "findByName")
    public List<Account> findByName(String name) {
        return accountService.findByName(name);
    }

    @RequestMapping(value = "findAll2")
    public List<Account> findAll2() {
        return accountService.findAll2();
    }

}
