package com.xhx.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.xhx.json.entity.Hourse;
import com.xhx.json.entity.Person;
import com.xhx.json.entity.User;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private User user;
    {
        user = new User();
        user.setId("111");
        user.setName("xuhaixing");
        user.setBirthday(LocalDate.of(1993,8,18));
        user.setAge(25);
        user.setMoney(100000.0);
        user.setDate(new Date());
    }

    ObjectMapper mapper = new ObjectMapper();
    {
        //出现未知属性时不报错
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * @JsonIgnore 修饰的属性不会进行json操作
     */
    @Test
    public void testJson1() throws Exception{

        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String str = mapper.writeValueAsString(user);

        //还可以输出到文件、流、字节等
        System.out.println(str);
        //{"id":"111","name":"xuhaixing","age":25,"money":100000.0,"date":1539092674111}

        User user = mapper.readValue(str, User.class);
        System.out.println(user);
        //User{id='111', name='xuhaixing', age=25, birthday=null, money=100000.0, date=Tue Oct 09 21:44:34 CST 2018}
    }

    /**
     * 数组的序列号与反序列化
     * @throws Exception
     */
    @Test
     public void testJson2() throws Exception{
        List<User> users = new ArrayList<>();
        users.add(user);

        String s = mapper.writeValueAsString(users);
        System.out.println(s);
        //[{"id":"111","age":25,"money":100000.0,"date":"2018年10月09日","fullName":"xuhaixing"}]

        List<User> userList = mapper.readValue(s, new TypeReference<List<User>>() {
        });
        System.out.println(userList);
        //[User{id='111', name='xuhaixing', age=25, birthday=null, money=100000.0, date=Tue Oct 09 08:00:00 CST 2018}]
    }

    /**
     * 自定义序列化
     * @throws Exception
     */
    @Test
    public void testJson3() throws Exception{
        Hourse hourse = new Hourse();
        hourse.setBuildDate(new Date());
        hourse.setLocation("河北省");

        String s = mapper.writeValueAsString(hourse);
        System.out.println(s);
        //{"id":"自定义","location":"河北省"}
    }

    /**
     * @JsonCreator
     * @throws Exception
     */
    @Test
    public void testJson4() throws Exception{
        Person person = new Person("abcd");
        person.setAddress("河北省");
        person.setBirthday(new Date());
        person.setName("xuhaixing");

        String s = mapper.writeValueAsString(person);
        System.out.println(s);


        Person person1 = mapper.readValue(s, Person.class);
        System.out.println(person1);
    }
}
