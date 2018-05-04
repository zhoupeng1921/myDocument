package com.xhx.springboot.controller;

import com.xhx.springboot.entity.Account;
import com.xhx.springboot.service.AccountService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhaixing
 * @date 2018/5/2 9:55
 */
@RestController
@RequestMapping("account2")
public class AccountController2 {

    @Autowired
    private AccountService2 accountService2;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public int add(@RequestBody Account account) {
        return accountService2.insert(account);
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public int update0(@RequestBody Account account) {
        return accountService2.updateByPrimaryKey(account);
    }
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public int delete(@RequestBody int id) {
        return  accountService2.deleteByPrimaryKey(id);
    }
    @RequestMapping(value = "findById", method = RequestMethod.POST)
    public Account findById(@RequestBody int id) {
        return  accountService2.selectByPrimaryKey(id);
    }

}
