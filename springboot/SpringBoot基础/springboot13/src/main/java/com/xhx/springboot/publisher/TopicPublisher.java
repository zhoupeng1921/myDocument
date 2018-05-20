package com.xhx.springboot.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * xuhaixing
 * 2018/5/17 22:04
 */
@Component
public class TopicPublisher {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String message = "TopicMessage发送啦";
       // amqpTemplate.convertAndSend("TOPIC_EXCHANGE","TOPIC.B",message); //两个topic消费者都会收到
        amqpTemplate.convertAndSend("TOPIC_EXCHANGE","TOPIC.C",message); //只有第一个topic消费者会收到
    }
}
