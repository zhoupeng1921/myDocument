package cn.itcast.service.impl;

import cn.itcast.dao.PersonDao;
import cn.itcast.domain.Person;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("personService")
public class PersonServiceImpl implements cn.itcast.service.PersonService {
    @Resource
    private PersonDao personDao;
    public List<Person> find(Map map){
       return  personDao.find(map);
    }
    public void insert(Person person){
        personDao.insert(person);
    }
}
