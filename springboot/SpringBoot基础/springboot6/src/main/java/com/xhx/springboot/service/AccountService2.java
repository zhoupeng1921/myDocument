package com.xhx.springboot.service;

import com.xhx.springboot.entity.Account;
import com.xhx.springboot.mapper2.AccountMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuhaixing
 * @date 2018/5/3 18:49
 */
@Service
public class AccountService2 {

    @Autowired
    private AccountMapper2 accountMapper;


    public int deleteByPrimaryKey(Integer id) {
        return accountMapper.deleteByPrimaryKey(id);
    }

    public int insert(Account record) {
        return accountMapper.insert(record);
    }

    public int insertSelective(Account record) {
        return accountMapper.insertSelective(record);
    }

    public Account selectByPrimaryKey(Integer id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Account record) {
        return accountMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Account record) {
        return accountMapper.updateByPrimaryKey(record);
    }
}
