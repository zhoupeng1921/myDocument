package com.xhx.springboot.service;

import com.github.pagehelper.PageHelper;
import com.xhx.springboot.entity.Account;
import com.xhx.springboot.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * xuhaixing
 * 2018/8/21 21:40
 **/
@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public List<Account> getByName(String name){
        //从1开始
        PageHelper.startPage(2,2);
        List<Account> accounts = accountMapper.likeName(name);
        return accounts;
    }

}
