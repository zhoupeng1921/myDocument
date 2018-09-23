package com.xhx.springboot.utils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * xuhaixing
 * 2018/9/20 21:38
 **/
public class SqlQueryHelper<T> {
    private Class<T> clazz;
    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;
    private Root<T> root;
    private CriteriaQuery<T> criteriaQuery;

    public SqlQueryHelper(Class<T> clazz, EntityManager entityManager) {
        this.clazz = clazz;
        this.entityManager = entityManager;
        this.criteriaBuilder = this.entityManager.getCriteriaBuilder();
        this.criteriaQuery = criteriaBuilder.createQuery(this.clazz);
        this.root = criteriaQuery.from(this.clazz);
    }

    public static SqlQueryHelper getSqlQueryHelper(Class clazz, EntityManager entityManager) {
        return new SqlQueryHelper(clazz, entityManager);
    }

    public List<T> conditionList(List<Condition> conditions) {
        List<Predicate> predicates = new ArrayList<>();
        conditions.stream().forEach(condition -> {
            predicates.add(asPredicate(condition));
        });

        return null;
    }

    public Predicate asPredicate(Condition condition) {

        switch (condition.getOperator()) {
            case GE:
                break;
            case GT:
                break;
            case LE:
                break;
            case LT:
                break;
            case LIKE:
                break;
            case NOTLIKE:
                break;
            case EQUAL:
                break;
            case NOTEQUAL:
                break;
            case IN:
                break;
            case NOTIN:
                break;
            default:
                break;
        }

        return null;
    }


}
