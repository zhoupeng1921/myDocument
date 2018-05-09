package com.xhx.springboot.service;

import com.xhx.springboot.mapper.AccountMapper;
import com.xhx.springboot.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public int add(Account account) {
        return accountMapper.add(account.getName(), account.getMoney());
    }

    public int update(Account account) {
        return accountMapper.update(account.getName(), account.getMoney(), account.getId());
    }

    public int delete(int id) {
        return accountMapper.delete(id);
    }

    public Account findById(int id) {
        return accountMapper.findAccount(id);
    }

    public List<Account> findList() {
        return accountMapper.findAccountList();
    }
}
