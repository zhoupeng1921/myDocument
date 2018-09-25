package com.xhx.springboot;

import com.xhx.springboot.entity.EventBody;
import com.xhx.springboot.event.MyEvent;
import com.xhx.springboot.publisher.MyPublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot31ApplicationTests {

    @Autowired
    private MyPublisher myPublisher;

    @Test
    public void testPublish() {
        EventBody eventBody = new EventBody("xuhaixing","我的事件");
        MyEvent myEvent = new MyEvent(eventBody);
        myPublisher.publisMess(myEvent);
    }

}
