package com.xhx.springboot.mapper2;

import com.xhx.springboot.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper2 {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}