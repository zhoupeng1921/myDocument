package com.example.demo.dao;

import com.example.demo.bean.Cat;

//@Mapper
public interface CatMapper {
    void insert(Cat cat);
    void update(Cat cat);
    void delete(int id);
    Cat select(int id);
}
