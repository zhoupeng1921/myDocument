package com.xhx.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.xhx.json.entity.Hourse;
import com.xhx.json.entity.Person;
import com.xhx.json.entity.User;
import com.xhx.json.entity2.Animal;
import com.xhx.json.entity2.Lion;
import com.xhx.json.entity2.Tiger;
import com.xhx.json.entity2.Zoo;
import com.xhx.json.entity3.Phone;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

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
        user.setDate2(new Date());
        user.setDate3(new Date());
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

        //mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String str = mapper.writeValueAsString(user);

        //还可以输出到文件、流、字节等
        System.out.println(str);
        //有根时的输出：{"root":{"age":25,"date":"2018年10月10日 22:27:41","date2":1539181661291,"date3":"2018-10-10T14:27:41.291+0000","fullName":"xuhaixing"}}

        User user = mapper.readValue(str, User.class);
        System.out.println(user);
        //User{id='null', name='xuhaixing', age=25, birthday=null, money=null, compute='null', date=Wed Oct 10 22:33:48 CST 2018, date2=Wed Oct 10 22:33:48 CST 2018, date3=Wed Oct 10 22:33:48 CST 2018}
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
        /**
         * {"id":"abcd","name":"xuhaixing","birthday":1539167688526,"address":"河北省"}
         * Person{id='abcd', name='xuhaixing', birthday=Wed Oct 10 22:33:26 CST 2018, address='河北省'}
         */
    }


    /**
     * @JsonTypeInfo
     * @throws Exception
     */
    @Test
    public void testJson5() throws Exception{
        Zoo zoo = new Zoo();
        Lion lion = new Lion();
        lion.setName("狮子");
        lion.setAge(2);

        Tiger tiger = new Tiger();
        tiger.setName("老虎");
        tiger.setAge(3);
        List<Animal> animals = new ArrayList<>();
        animals.add(lion);
        animals.add(tiger);
        zoo.setAnimals(animals);
        zoo.setCity("北京");
        zoo.setName("北京天上地下动物园");

        String s = mapper.writeValueAsString(zoo);
        System.out.println(s);
        //{"name":"北京天上地下动物园","city":"北京","animals":[{"@Clazz":"com.xhx.json.entity2.Lion","name":"狮子","age":2},{"@Clazz":"com.xhx.json.entity2.Tiger","name":"老虎","age":3}]}

        Zoo zoo1 = mapper.readValue(s, Zoo.class);
        System.out.println(zoo1);
        //com.xhx.json.entity2.Zoo@69a3d1d
    }

    @Test
    public void testJson6() throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("id","abdae");
        map.put("name","我的");
        map.put("model","nokia");
        map.put("size","6.0");
        String s = mapper.writeValueAsString(map);
        Phone phone = mapper.readValue(s, Phone.class);
        System.out.println(phone);
        //Phone{id='abdae', model='nokia', other={size=6.0, name=我的}}
    }
}
