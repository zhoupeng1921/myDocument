package com.xhx;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xuhaixing
 * @date 2018/3/18 9:52
 */
public class test {
    private static ApplicationContext applicationContext;

    static{
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testRedisTemplate(){
        StringRedisTemplate redisTemplate = (StringRedisTemplate)applicationContext.getBean("redisTemplate");

        redisTemplate.opsForValue().set("name","xiaohong");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
        redisTemplate.delete("name");
        name = redisTemplate.opsForValue().get("name");
        System.out.println(name);



        redisTemplate.opsForList().rightPush("myList","1");
        redisTemplate.opsForList().leftPush("myList","2");
        List<String> myList = redisTemplate.opsForList().range("myList", 0, -1);
        myList.forEach(System.out::println);

        redisTemplate.opsForHash().put("myHash","name","xiaoxiao");
        redisTemplate.opsForHash().put("myHash","age","25");
        Map<Object, Object> myHash = redisTemplate.opsForHash().entries("myHash");
        Set<Map.Entry<Object, Object>> entries = myHash.entrySet();
        entries.stream().forEach(enty->{
            System.out.println(enty.getKey()+"   "+enty.getValue());
        });


        redisTemplate.opsForSet().add("city","beijing","hebei");
        Set<String> city = redisTemplate.opsForSet().members("city");
        city.forEach(System.out::println);

        redisTemplate.opsForZSet().add("citys","beijing",80);
        redisTemplate.opsForZSet().add("citys","hebei",89);
        Set<String> city1 = redisTemplate.opsForZSet().range("citys", 0, -1);
        city1.forEach(System.out::println);
    }


    @Test
    public void testJedisPool(){
        JedisPool pool = (JedisPool)applicationContext.getBean("jedisPool");
        Jedis jedis = null;

        try {
            jedis = pool.getResource();
           // jedis.auth("xuhaixing");
            jedis.set("name", "lixiaoxiao");
            String name = jedis.get("name");
            System.out.println(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
