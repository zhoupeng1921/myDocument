package cn.itcast.service;

import cn.itcast.domain.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {
    List<Person> find(Map map);
    void insert(Person person);
}
