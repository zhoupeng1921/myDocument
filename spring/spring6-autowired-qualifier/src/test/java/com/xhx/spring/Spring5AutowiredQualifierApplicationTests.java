package com.xhx.spring;

import com.xhx.spring.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring5AutowiredQualifierApplicationTests {

    @Autowired(required = false)  //一般在开发环境，不确定是否能注入时用
    private User user1;

    @Autowired
    @Qualifier(value = "user1")
    private User user2;

    @Test
    public void testAuto() {
        System.out.println(user2.getName());
        System.out.println(user1.getName());
    }

}
