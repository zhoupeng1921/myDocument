package com.xhx.springboot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * xuhaixing
 * 2018/5/17 21:39
 *
 * 两个消费者会轮流接收消息
 */
@Component
@RabbitListener(queues = "DIRECT_A") //监听同一个队列 两个消费者会轮流接收消息
public class DirectConsumer {
    @RabbitHandler
    public void receive(String message){
        System.out.println("1收到的消息是："+message);
    }
}
