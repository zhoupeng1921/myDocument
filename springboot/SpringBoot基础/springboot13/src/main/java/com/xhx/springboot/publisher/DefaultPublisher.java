package com.xhx.springboot.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * xuhaixing
 * 2018/5/17 21:16
 */
@Component
public class DefaultPublisher {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String message = "defaultMessage发送啦";
        amqpTemplate.convertAndSend("DEFAULT_A",message);
    }

}
