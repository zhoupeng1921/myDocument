package com.xhx.springboot.dao.impl;

import com.xhx.springboot.dao.AccountDao;
import com.xhx.springboot.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/4/28 10:33
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Account account) {
        return jdbcTemplate.update("INSERT  INTO account(name,money) values(?,?)",account.getName(),account.getMoney());
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("UPDATE account set NAME =?, MONEY=? WHERE  ID=?",account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from TABLE account where id=?",id);
    }

    @Override
    public Account findById(int id) {
        List<Account> accountList = jdbcTemplate.query("select * from account where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Account.class));
        if(accountList!=null && accountList.size()>0){
            return accountList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<Account> findList() {
        List<Account> list = jdbcTemplate.query("select * from account", new Object[]{}, new BeanPropertyRowMapper(Account.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
