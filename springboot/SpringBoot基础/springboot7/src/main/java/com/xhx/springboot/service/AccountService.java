package com.xhx.springboot.service;

import com.xhx.springboot.entity.Account;
import com.xhx.springboot.repository.AccountRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public int save(Account account) {
        accountRepository.save(account);
        return 1;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findById(String id) {
        return accountRepository.findById(id).get();
    }

    public List<Account> findByName(String name) {
        return accountRepository.findByName(name);
    }

    public List<Account> findAll2() {
        return mongoTemplate.findAll(Account.class);
    }
    public List<Account> findRangeWithMoney(Double money){
        return accountRepository.fingRangeWithMoney(money);
    }

    public void save2(Account account){
        //根据id匹配，有时更新，没有插入
        mongoTemplate.save(account);
    }
    public Account findById2(String id){
        Account account = mongoTemplate.findById(id, Account.class);
        return account;
    }

    public Account findByName2(String name){
        Query query = new Query(Criteria.where("name").is(name));
        Account account = mongoTemplate.findOne(query, Account.class);
        return account;
    }
    public Document findByName3(String name){
        Document document = new Document();
        document.append("name",name);
        document = mongoTemplate.executeCommand(document);
        return document;
    }
}
