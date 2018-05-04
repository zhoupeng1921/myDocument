package com.xhx.springboot.Controller;

import com.xhx.springboot.entity.Account;
import com.xhx.springboot.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/5/4 9:26
 */

@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @RequestMapping(value = "save")
    public int save(@RequestBody Account account){
        accountRepository.save(account);
        return 1;
    }

    @RequestMapping(value = "findAll")
    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    @RequestMapping(value = "findById")
    public Account findById(String id){
        return accountRepository.findById(id).get();
    }
    @RequestMapping(value = "findByName")
    public List<Account> findByName(String name){
        return accountRepository.findByName(name);
    }

    @RequestMapping(value = "findAll2")
    public List<Account> findAll2(){
        return mongoTemplate.findAll(Account.class);
    }

}
