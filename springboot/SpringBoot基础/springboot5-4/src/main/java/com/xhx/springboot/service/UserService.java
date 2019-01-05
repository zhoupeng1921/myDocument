package com.xhx.springboot.service;


import com.xhx.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;

    public User getUserWithAccount(Integer id){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        //Join<User, Account> account = root.join(root.getModel().getSingularAttribute("account", Account.class), JoinType.LEFT);



        Predicate pre = criteriaBuilder.equal(root.get("id"), id);
        query.where(pre);

        User singleResult = entityManager.createQuery(query).getSingleResult();
        return singleResult;


    }

    public List<User> getUserWithAccountList(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        List<User> resultList = entityManager.createQuery(query).getResultList();
        return resultList;


    }
}
