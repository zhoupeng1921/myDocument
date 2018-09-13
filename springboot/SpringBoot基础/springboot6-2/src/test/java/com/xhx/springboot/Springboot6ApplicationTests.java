package com.xhx.springboot;

import com.xhx.springboot.controller.UserController;
import com.xhx.springboot.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot6ApplicationTests {

    @Autowired
    private UserController userController;

    @Test
    public void testFindById() {
        User user = userController.findById(2);
        System.out.println(user);
    }

}
