package com.xhx.ms.repository;

import com.xhx.ms.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by xuhaixing on 17-11-25.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person,String> {
}
