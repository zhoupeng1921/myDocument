package com.xhx.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;

    public void getUserWithAccount(Integer id){



    }
}
