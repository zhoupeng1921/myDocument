package com.xhx.springboot.repository;

import com.xhx.springboot.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/5/4 9:22
 */
@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    List<Account> findByName(String name);

    //注解构造条件
    @Query(value = "{'money':{$lt:?0}}")
    List<Account> fingRangeWithMoney(Double money);

}
