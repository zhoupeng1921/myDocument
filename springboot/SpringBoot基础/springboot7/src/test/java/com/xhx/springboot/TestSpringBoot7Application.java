package com.xhx.springboot;


import com.xhx.springboot.Controller.AccountController;
import com.xhx.springboot.entity.Account;
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

    @Test
    public void testSave(){
        Account account = new Account();
        account.setMoney(5000.0);
        account.setName("小霞");
        accountController.save(account);
    }
    @Test
    public void testFindByName(){
        List<Account> accountList = accountController.findByName("小霞");
        System.out.println(accountList);
    }

}
