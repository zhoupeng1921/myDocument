package com.xhx.redis;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisCluster;

public class testJedisCluster2 {
    public static ClassPathXmlApplicationContext context;
    static {
        context = new ClassPathXmlApplicationContext("classpath:applicationContext2.xml");
    }

    @Test
    public void testJedisCluster(){
        RedisTemplate redisTemplate = (RedisTemplate)context.getBean("redisTemplate");
        redisTemplate.opsForValue().set("name","小红");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }
}
