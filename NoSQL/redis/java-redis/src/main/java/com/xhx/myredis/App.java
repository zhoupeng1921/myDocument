package com.xhx.myredis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * jedis连接redis
     */
    @Test
    public void testJedis(){
        Jedis jedis = new Jedis("192.168.94.150",6379);
        jedis.auth("xuhaixing");
        jedis.set("name","xiaofeifei");
        String result =jedis.get("name");
        System.out.println(result);
        jedis.close();
    }

    @Test
    public void testPoolJedis(){
        JedisPool jedisPool = new JedisPool("192.168.94.150",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.auth("xuhaixing");
        String result = jedis.get("name");
        System.out.println(result);
        jedis.close();
        jedisPool.close();
    }
}
