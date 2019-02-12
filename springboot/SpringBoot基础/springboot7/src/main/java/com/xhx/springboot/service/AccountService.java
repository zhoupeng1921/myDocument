package com.xhx.springboot.service;

import com.xhx.springboot.entity.Account;
import com.xhx.springboot.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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
}
