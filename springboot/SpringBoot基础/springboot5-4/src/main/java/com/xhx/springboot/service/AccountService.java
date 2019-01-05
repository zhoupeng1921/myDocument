package com.xhx.springboot.service;

import com.xhx.springboot.dao.AccountDao;
import com.xhx.springboot.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        return accountDao.findById(id).orElse(null);

    }

    public List<Account> findList() {
        return accountDao.findAll();
    }


    public List<Account> findByCondition(Account account) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        //返回类型 select * 中的 *
        CriteriaQuery<Account> query = criteriaBuilder.createQuery(Account.class);
        //form
        Root<Account> root = query.from(Account.class);
        //where条件
        Predicate predicate1 = criteriaBuilder.like(root.get("bankNumber"), "%" + account.getBankNumber() + "%");
        query.where(predicate1);
        TypedQuery<Account> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    public List<Integer> findIdsByCondition(String bankNumber) {

        CriteriaBuilder criteriaBuilder =
                entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> query = criteriaBuilder.createQuery(Integer.class);
        Root<Account> root = query.from(Account.class);
        //返回指定列
        query.select(root.get("id"));

        Predicate pre1 = criteriaBuilder.like(root.get("bankNumber"), "%" + bankNumber + "%");
        query.where(pre1);

        List<Integer> resultList = entityManager.createQuery(query).getResultList();
        return resultList;

    }
    public List<Account> findByBankNum(String bankNumber){
        CriteriaBuilder criteriaBuilder =
                entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> query = criteriaBuilder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);

        //通过构造函数赋值，顺序要一致，返回结果只有这三列值
        query.multiselect(root.get("id"),root.get("bankNumber"),root.get("version"));

        Predicate pre1 = criteriaBuilder.like(root.get("bankNumber"), "%" + bankNumber + "%");
        query.where(pre1);

        List<Account> resultList = entityManager.createQuery(query).getResultList();
        return resultList;
    }
}
