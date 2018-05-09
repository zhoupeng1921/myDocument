package com.xhx.springboot.dao;

import com.xhx.springboot.entity.Account;

import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/4/28 10:30
 */
public interface AccountDao {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findById(int id);

    List<Account> findList();
}
