package com.xhx.springboot.dao;

import com.xhx.springboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author xuhaixing
 * @date 2018/5/2 11:19
 */
@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {
    

}
