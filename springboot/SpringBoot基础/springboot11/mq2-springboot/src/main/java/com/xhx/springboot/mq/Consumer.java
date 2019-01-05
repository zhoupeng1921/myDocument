package com.xhx.springboot.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {


    /**
     * 这么配置不好，destination会造成队列中也会生成Topic的名称，建议写到containerFactory中
     * 见第三个实例
     * @param message
     */
    @JmsListener(destination = "Q_TOPIC_USERIDENTITY",containerFactory = "topicJmsContainerFactory")
    public void receiveTopic(String message){
        System.out.println("收到的TOPIC消息:"+message);
    }


    @JmsListener(destination = "Q_QUEUE_USERIDENTITY",containerFactory = "queueJmsContainerFactory")
    public void receiveQueue(String message){
        System.out.println("收到的QUEUE消息:"+message);
    }
}
