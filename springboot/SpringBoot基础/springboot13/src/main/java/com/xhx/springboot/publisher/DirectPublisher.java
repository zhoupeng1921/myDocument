package com.xhx.springboot.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * xuhaixing
 * 2018/5/17 21:36
 */
@Component
public class DirectPublisher {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String message = "directMessage发送啦";
        amqpTemplate.convertAndSend("DIRECT_EXCHANGE","DIRECT_QUEUE",message); //routing key与bingding key完全匹配消费者才接收
    }
}
