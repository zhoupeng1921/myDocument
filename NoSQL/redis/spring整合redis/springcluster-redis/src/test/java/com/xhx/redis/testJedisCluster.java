package com.xhx.redis;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisCluster;

public class testJedisCluster {
    public static ClassPathXmlApplicationContext context;
    static {
        context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void testJedisCluster(){
        JedisCluster redisCluster = (JedisCluster)context.getBean("redisCluster");
        redisCluster.set("name", "xuhaixing");
        System.out.println(redisCluster.get("name"));
    }
}
