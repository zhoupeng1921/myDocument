package com.xhx.springboot;

import com.xhx.springboot.publish.RabbitPublish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot12ApplicationTests {

    @Autowired
    private RabbitPublish rabbitPublish;

    @Test
    public void contextLoads() {
        rabbitPublish.sendMQ();
    }

}
