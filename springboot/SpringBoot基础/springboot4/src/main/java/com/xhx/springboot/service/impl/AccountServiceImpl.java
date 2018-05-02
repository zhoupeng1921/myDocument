package com.xhx.springboot.service.impl;

import com.xhx.springboot.dao.AccountDao;
import com.xhx.springboot.entity.Account;
import com.xhx.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/5/2 9:53
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public int add(Account account) {
        return accountDao.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDao.delete(id);
    }

    @Override
    public Account findById(int id) {
        return accountDao.findById(id);
    }

    @Override
    public List<Account> findList() {
        return accountDao.findList();
    }
}
