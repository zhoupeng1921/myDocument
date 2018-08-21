package com.xhx.springboot.mapper;

import com.xhx.springboot.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * xuhaixing
 * 2018/8/21 21:30
 **/
@Mapper
public interface AccountMapper {

    @Select("select * from account where name like concat('%',#{name},'%')")
    public List<Account>  likeName(@Param("name") String name);

    @Select("select * from account where id = #{id}")
    public Account getById(int id);

    @Select("select name from account where id = #{id}")
    public String getNameById(int id);
}
