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
        accountDao.save(account);
        return 1;
    }

    @Override
    public int update(Account account) {
        accountDao.save(account);  //插入和更新同一个方法，内部原理先根据id查一下，没有insert,有update
        return 1;
    }

    @Override
    public int delete(int id) {
        accountDao.deleteById(id);
        return 1;
    }

    @Override
    public Account findById(int id) {
        return  accountDao.findById(id).get();

    }

    @Override
    public List<Account> findList() {
        return accountDao.findAll();
    }
}
