package com.xhx.springboot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * xuhaixing
 * 2018/5/17 21:39
 *
 */
@Component
@RabbitListener(queues = "TOPIC_A")
public class TopicConsumer {
    @RabbitHandler
    public void receive(String message){
        System.out.println("1收到的消息是："+message);
    }
}
