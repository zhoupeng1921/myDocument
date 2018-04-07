package com.xhx.testmybatis.service;

import com.xhx.testmybatis.dao.PersonMapper;
import com.xhx.testmybatis.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuhaixing on 17-11-16.
 */
@Service
public class PersonService {
    @Autowired
    private PersonMapper personMapper;

    public int deletePerson(String id){
        return personMapper.deleteByPrimaryKey(id);
    }

    public int insertPerson (Person person){
        return personMapper.insert(person);
    }


    public int insertPersonSelective(Person person){
        return personMapper.insertSelective(person);
    }


    public Person selectPersonByPrimaryKey(String id){
        return personMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Person person){
        return personMapper.updateByPrimaryKeySelective(person);
    }

    public int updateByPrimaryKey(Person person){
        return personMapper.updateByPrimaryKey(person);
    }

}
