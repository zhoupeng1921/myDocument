package com.xhx.springboot.publish;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * xuhaixing
 * 2018/5/11 16:29
 */
@RestController
public class RabbitPublish {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @RequestMapping("sendMQ")
    public String sendMQ(){
        //发送到默认exchage
        rabbitmqTemplate.convertAndSend("Q_QUEUE","xuhaixing");
        return "success";
    }
}
