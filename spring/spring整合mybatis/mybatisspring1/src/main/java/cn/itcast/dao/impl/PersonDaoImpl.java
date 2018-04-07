package cn.itcast.dao.impl;

import cn.itcast.domain.Person;
import cn.itcast.mapper.PersonMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;
import java.util.List;

@Repository("personDao")
public class PersonDaoImpl extends SqlSessionDaoSupport implements cn.itcast.dao.PersonDao {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List<Person> find(Map map){
        PersonMapper mapper = this.getSqlSession().getMapper(PersonMapper.class);
        return mapper.find(map);
    }
    public void insert(Person person){
        PersonMapper mapper = this.getSqlSession().getMapper(PersonMapper.class);
        mapper.insert(person);
    }
}
