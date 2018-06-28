package com.xhx.springboot.service;

import com.xhx.springboot.dao.AccountDao;
import com.xhx.springboot.entity.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuhaixing
 * @date 2018/5/2 9:53
 */
@Service
public class AccountService {
    private static Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountDao accountDao;

    public Account findByName(String name) throws Exception{

        try {
            return accountDao.findByName(name);
        } catch (Exception e) {
            throw  new Exception("数据库异常",e);
        }
    }

}
