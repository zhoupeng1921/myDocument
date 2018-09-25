package com.xhx.springboot.publisher;

import com.xhx.springboot.event.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyPublisher{

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 自己定义的发布事件 用ApplicationContext发布
     * @param myEvent
     */
    public void publisMess(MyEvent myEvent){
        applicationContext.publishEvent(myEvent);
    }
}
