package com.xhx.springboot;

import com.xhx.springboot.controller.UserController;
import com.xhx.springboot.entity.User;
import com.xhx.springboot.enums.GenderEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot5ApplicationTests {

    @Autowired
    private UserController userController;

    @Test
    public void testConvertToDB() {
        User user = new User();
        user.setName("小白");
        user.setAge(23);
        user.setGender(GenderEnum.WOMAN);
        userController.add(user); //GenderEnum类型已经转换
    }

    @Test
    public void testDBToEntity() {
        User user = userController.findById(2);//GenderEnum类型已经转换
        System.out.println(user);
        //User{id=2, name='小徐', age=25, gender=MAN, version=0}
    }

}
