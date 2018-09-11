package com.xhx.springboot.dao;

import com.xhx.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xuhaixing
 * @date 2018/5/2 11:19
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
