package cn.itcast.mapper;

import cn.itcast.domain.Person;

import java.util.List;
import java.util.Map;

public interface PersonMapper {
    List<Person> find(Map map);
    void insert(Person person);
}
