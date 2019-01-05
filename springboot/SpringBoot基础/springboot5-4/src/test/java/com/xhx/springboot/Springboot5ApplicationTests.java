package com.xhx.springboot;

import com.xhx.springboot.controller.AccountController;
import com.xhx.springboot.entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot5ApplicationTests {

    @Autowired
    private AccountController accountController;

    @Test
    public void testVersion() {
        Account account = new Account();
        account.setId(10);
        account.setBankNumber("621756841235485");
        account.setBalance(7999.0);
        account.setVersion(0);

        //accountController.update(account);
        //accountController.updateAccount(account);
        //int i = accountController.updateAccountByVersion(account);
        //System.out.println(i);
    }

}
