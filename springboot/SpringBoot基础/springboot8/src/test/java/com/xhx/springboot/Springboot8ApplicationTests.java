package com.xhx.springboot;

import com.xhx.springboot.dao.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot8ApplicationTests {

    @Autowired
    private AccountDao accountDao;

    @Test
    public void contextLoads() {
        accountDao.setKey("name", "小冰冰");
        String name = accountDao.getValue("name");
        System.out.println(name);
    }
}
