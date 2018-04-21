package com.xhx.ms.service;

import com.xhx.ms.entity.Person;
import com.xhx.ms.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xuhaixing on 17-11-25.
 */
@Service
public class PersonService {
    @Resource
    private PersonRepository personRepository;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public void test(){
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mykey1","random1="+Math.random());
        System.out.println(valueOperations.get("mykey1"));

    }

    @Cacheable(value="person") //key为序列化生成的key,原理 缓存存储入参和出参
    public Person findById(String id){
        System.out.println("------findById-----id = "+id);
        return personRepository.findOne(id);
    }

   // @CacheEvict(value="person",allEntries=true) //删除全部
    @CacheEvict(value="person",key="'com.xhx.ms.service.PersonServicefindById'+#id") //删除指定
    public void deleteFromCache(String id){
        System.out.println("------deleteFromCache-----从缓存删除");
    }

}
