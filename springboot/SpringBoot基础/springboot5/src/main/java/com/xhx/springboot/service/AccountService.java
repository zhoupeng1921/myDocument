package com.xhx.springboot.service;

import com.xhx.springboot.entity.Account;

import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/5/2 9:53
 */

public interface AccountService {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findById(int id);

    List<Account> findList();
}
