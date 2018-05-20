package com.xhx.springboot.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * xuhaixing
 * 2018/5/17 21:54
 */
@Component
public class FanoutPublisher {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String message = "FanoutMessage发送啦";
        amqpTemplate.convertAndSend("FANOUT_EXCHANGE",null,message); //与fanout绑定的消费者都能收到，略过routing key
    }
}
