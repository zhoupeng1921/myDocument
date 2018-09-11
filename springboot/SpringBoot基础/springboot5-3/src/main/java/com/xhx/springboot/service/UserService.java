package com.xhx.springboot.service;

import com.xhx.springboot.dao.UserDao;
import com.xhx.springboot.dao.UserDao;
import com.xhx.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/5/2 9:53
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    public int add(User user) {
        userDao.save(user);
        return 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(User user) {
        userDao.save(user);  //插入和更新同一个方法，内部原理先根据id查一下，没有insert,有update
        return 1;
    }


    public int delete(int id) {
        userDao.deleteById(id);
        return 1;
    }

    public User findById(int id) {
        return userDao.findById(id).get();

    }

    public List<User> findList() {
        return userDao.findAll();
    }
}
