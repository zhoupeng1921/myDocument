package com.example.demo.service;

import com.example.demo.bean.Cat;
import com.example.demo.dao.CatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CatService {
    @Autowired
    private CatMapper catMapper;

    public void insert(Cat cat) {
        catMapper.insert(cat);
    }

    public void update(Cat cat) {
        catMapper.update(cat);
    }

    public void delete(int id) {
        catMapper.delete(id);
    }

    public Cat select(int id) {
        return catMapper.select(id);
    }
}
