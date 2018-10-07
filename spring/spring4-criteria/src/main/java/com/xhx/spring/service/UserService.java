package com.xhx.spring.service;

import com.xhx.spring.domain.User;
import com.xhx.spring.utils.CriteriaQueryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private EntityManager entityManager;


    public List<User> getUserByName(String name){
        CriteriaQueryHelper criteriaQueryHelper = CriteriaQueryHelper.getCriteriaQueryHelper(User.class, entityManager);
        criteriaQueryHelper.like("name",name,2);
        TypedQuery query = entityManager.createQuery(criteriaQueryHelper.createCriteriaQuery());
        List resultList = query.getResultList();
        return resultList;
    }

}
