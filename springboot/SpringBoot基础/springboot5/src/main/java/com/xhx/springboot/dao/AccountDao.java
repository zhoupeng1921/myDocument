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


    @Modifying
    @Query("update Account set name=:name, money=:money where id=:id")
    int updateAccount(@Param("id") int id,@Param("name") String name, @Param("money") double money);


    @Modifying  //通知jpa这是一个update或者delete操作，jpql不支持insert操作
    @Query("update Account set name=:name, money=:money,version=:version+1 where id=:id and version=:version")
    int updateAccountByVersion(@Param("id") int id,@Param("name") String name, @Param("money") double money,@Param("version") int version);

    @Query(value = "select count(*) from account",nativeQuery = true)//使用原生sql进行查询
    long selectCount();

}
