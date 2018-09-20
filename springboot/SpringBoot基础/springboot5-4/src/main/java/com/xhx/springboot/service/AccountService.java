package com.xhx.springboot.service;

import com.xhx.springboot.dao.AccountDao;
import com.xhx.springboot.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.beans.Transient;
import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/5/2 9:53
 */
@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private EntityManager entityManager;

    @Transactional(rollbackFor = Exception.class)
    public int add(Account account) {
        accountDao.save(account);
        return 1;
    }

    public Account findById(int id) {
        return accountDao.findById(id).get();

    }

    public List<Account> findList() {
        return accountDao.findAll();
    }


    public List<Account> findByCondition(Account account){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> query = criteriaBuilder.createQuery(Account.class); //返回类型 select * 中的 *
        Root<Account> root = query.from(Account.class);  //form
        Predicate predicate1 = criteriaBuilder.like(root.get("name"), "%" + account.getName() + "%"); //where条件
        query.where(predicate1);
        TypedQuery<Account> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
