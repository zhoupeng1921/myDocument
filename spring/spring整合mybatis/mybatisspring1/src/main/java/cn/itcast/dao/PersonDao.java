package cn.itcast.dao;

import cn.itcast.domain.Person;

import java.util.List;
import java.util.Map;

public interface PersonDao {
    List<Person> find(Map map);
    void insert(Person person);
}
