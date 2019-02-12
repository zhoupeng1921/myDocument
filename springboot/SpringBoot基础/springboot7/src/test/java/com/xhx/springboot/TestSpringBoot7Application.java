package com.xhx.springboot;


import com.xhx.springboot.controller.AccountController;
import com.xhx.springboot.entity.Account;
import com.xhx.springboot.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSpringBoot7Application {

    @Autowired
    private AccountController accountController;

    @Autowired
    private AccountService accountService;

    @Test
    public void testSave(){
        Account account = new Account();
        account.setMoney(10000.0);
        account.setName("小红");
        accountController.save(account);
    }
    @Test
    public void testFindByName(){
        List<Account> accountList = accountController.findByName("小白");
        System.out.println(accountList);
    }

    @Test
    public void testFindAll2(){
        List<Account> all2 = accountController.findAll2();
        System.out.println(all2);
    }

    @Test
    public void testMoneyRange(){
        List<Account> accountList = accountService.findRangeWithMoney(6000D);
        System.out.println(accountList);
    }

}
