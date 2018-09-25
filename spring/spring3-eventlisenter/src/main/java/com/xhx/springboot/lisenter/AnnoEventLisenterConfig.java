package com.xhx.springboot.lisenter;

import com.xhx.springboot.event.MyEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnnoEventLisenterConfig {

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadyEvent2(){
        System.out.println("程序启动了2");
    }
    @EventListener
    public void applicationReadyEvent3(ApplicationReadyEvent applicationReadyEvent){
        System.out.println("程序启动了3");
    }

    @Async
    @EventListener
    public void myEventLisenter(MyEvent myEvent){
        System.out.println(myEvent.getEventBody().toString());
    }
}
