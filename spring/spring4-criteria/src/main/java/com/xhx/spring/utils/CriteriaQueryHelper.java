package com.xhx.spring.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.*;

public class CriteriaQueryHelper {
    private static Logger logger = LoggerFactory.getLogger(CriteriaQueryHelper.class);

    private Class clazz;
    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery criteriaQuery;
    private Root root;
    private List<Predicate> predicates;
    private List<Order> orders;

    private CriteriaQueryHelper(Class clazz, EntityManager entityManager){
        this.clazz = clazz;
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
        this.criteriaQuery = criteriaBuilder.createQuery(this.clazz);
        this.root = this.criteriaQuery.from(this.clazz);
        this.orders = new ArrayList<>();
    }
    public static CriteriaQueryHelper getCriteriaQueryHelper(Class clazz, EntityManager entityManager){
        return new CriteriaQueryHelper(clazz,entityManager);
    }

    public void equal(String propertyName, Object value){
        if(isEmpty(value)){
            return;
        }
        this.predicates.add(this.criteriaBuilder.equal(this.root.get(propertyName),value));
    }
    public void notEqual(String propertyName, Object value){
        if(isEmpty(value)){
            return;
        }
        this.predicates.add(this.criteriaBuilder.notEqual(this.root.get(propertyName),value));
    }
    public void isNull(String propertyName){
        this.predicates.add(this.criteriaBuilder.isNull(this.root.get(propertyName)));
    }
    public void isNotNull(String propertyName){
        this.predicates.add(this.criteriaBuilder.isNotNull(this.root.get(propertyName)));
    }
    public void in(String propertyName, Collection collection){
        if(CollectionUtils.isEmpty(collection)){
            return;
        }
        this.predicates.add(this.criteriaBuilder.in(this.root.get(propertyName)).in(collection));
    }
    public void notIn(String propertyName, Collection collection){
        if(CollectionUtils.isEmpty(collection)){
            return;
        }
        this.predicates.add(this.criteriaBuilder.not(this.criteriaBuilder.in(this.root.get(propertyName)).in(collection)));
    }

    public void like(String propertyName,String value,int type){
        if(type==0){
            value="%"+value;
        }else if(type==1){
            value=value+"%";
        }else {
            value="%"+value+"%";
        }
        this.predicates.add(this.criteriaBuilder.like(this.root.get(propertyName),value));
    }

    public void between(String propertyName, Date from, Date to){
        if(isEmpty(from)||isEmpty(to)){
            return;
        }
        this.predicates.add(this.criteriaBuilder.between(this.root.get(propertyName),from,to));
    }
//    public void between(String propertyName, Number from, Number to){
//        if(isEmpty(from)||isEmpty(to)){
//            return;
//        }
//        this.predicates.add(this.criteriaBuilder.between(this.root.get(propertyName),from,to));
//    }
    public void ge(String propertyName,Object value){
        if(isEmpty(value)){
            return;
        }
        this.predicates.add(this.criteriaBuilder.greaterThanOrEqualTo(this.root.get(propertyName),value));
    }




    /**
     * 空的话返回true
     * @param value
     * @return
     */
    public Boolean isEmpty(Object value){
        if(value instanceof String){
            return value==null||"".equals(value);
        }else {
            return Objects.isNull(value);
        }
    }
}
