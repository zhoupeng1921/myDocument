package com.xhx.springboot.controller;

import com.xhx.springboot.publisher.DefaultPublisher;
import com.xhx.springboot.publisher.DirectPublisher;
import com.xhx.springboot.publisher.FanoutPublisher;
import com.xhx.springboot.publisher.TopicPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * xuhaixing
 * 2018/5/17 21:24
 */
@RestController
public class RabbitmqController {

    @Autowired
    private DefaultPublisher defaultPublisher;

    @Autowired
    private DirectPublisher directPublisher;


    @Autowired
    private FanoutPublisher fanoutPublisher;

    @Autowired
    private TopicPublisher topicPublisher;


    @RequestMapping("/send1")
    public String sendDefaultPublisher(){
        defaultPublisher.send();
        return "success";
    }

    @RequestMapping("/send2")
    public String sendDirectPublisher(){
        directPublisher.send();
        return "success";
    }

    @RequestMapping("/send3")
    public String sendFanoutPublisher(){
        fanoutPublisher.send();
        return "success";
    }
    @RequestMapping("/send4")
    public String sendTopicPublisher(){
        topicPublisher.send();
        return "success";
    }
}
