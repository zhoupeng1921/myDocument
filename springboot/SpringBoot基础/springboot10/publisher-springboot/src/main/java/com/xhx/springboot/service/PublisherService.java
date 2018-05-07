package com.xhx.springboot.service;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * xuhaixing
 * 2018/5/6 17:53
 */
@Service
public class PublisherService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String sendMessage(String name){
        try {
            redisTemplate.convertAndSend("TOPIC_USERNAME",name);
            return "消息发送成功了";

        }catch (Exception e){
            e.printStackTrace();
            return "消息发送失败了";
        }
    }
}
