package com.xhx.springboot.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    /**
     * @param message
     */
    @JmsListener(destination = "Q_TOPIC_USERIDENTITY",containerFactory = "topicJmsContainerFactory")
    public void receiveTopic(String message){
        System.out.println("收到的TOPIC消息:"+message);
    }

    /**
     * @param message
     */
    @JmsListener(destination = "Q_QUEUE_USERIDENTITY",containerFactory = "queueJmsContainerFactory")
    public void receiveQueue(String message){
        System.out.println("收到的QUEUE消息:"+message);
    }
}
