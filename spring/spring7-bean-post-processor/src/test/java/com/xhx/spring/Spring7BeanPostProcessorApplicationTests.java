package com.xhx.spring;

import com.xhx.spring.controller.UserController;
import com.xhx.spring.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring7BeanPostProcessorApplicationTests {

    @Autowired
    private UserController userController;

    @Test
    public void testController() {
        User user = userController.getUser();
        System.out.println(user);
    }

}
