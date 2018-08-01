package com.xhx.springboot.service.impl;

import com.xhx.springboot.dao.AccountDao;
import com.xhx.springboot.entity.Account;
import com.xhx.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/5/2 9:53
 */
@Service
public class AccountServiceImpl{

    @Autowired
    private AccountDao accountDao;

    @Transactional(rollbackFor = Exception.class)
    public int add(Account account) {
        accountDao.save(account);
        return 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(Account account) {
        accountDao.save(account);  //插入和更新同一个方法，内部原理先根据id查一下，没有insert,有update
        return 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateAccount(Account account){
        int i =accountDao.updateAccount(account.getId(),account.getName(),account.getMoney());
        return i;
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateAccountByVersion(Account account){
        int i =accountDao.updateAccountByVersion(account.getId(),account.getName(),account.getMoney(),account.getVersion());
        if(i==0){
            throw new ObjectOptimisticLockingFailureException("更新account失败",new Exception());
        }
        return i;
    }


    public int delete(int id) {
        accountDao.deleteById(id);
        return 1;
    }

    public Account findById(int id) {
        return accountDao.findById(id).get();

    }

    public List<Account> findList() {
        return accountDao.findAll();
    }
}
