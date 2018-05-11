package com.xhx.springboot.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * xuhaixing
 * 2018/5/11 16:47
 */
@Component
public class RabbitReceive {

    @RabbitListener(queues = "Q_QUEUE")
    @RabbitHandler
    public void receive(String text){
        System.out.println(text);
    }
}
