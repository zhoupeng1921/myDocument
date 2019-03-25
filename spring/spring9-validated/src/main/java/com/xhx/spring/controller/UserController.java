package com.xhx.spring.controller;


import com.xhx.spring.entity.User;
import com.xhx.spring.interfaces.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import java.util.Set;

@RestController
@RequestMapping(value = "user")
@Validated //验证方法参数内加的注解 add4方法，，不会验证add5()方法
public class UserController {


    @Autowired
    private Validator validator;

    /**
     * 加分组的只验证分组的注解,其他注解不验证
     * @param user
     * @return
     */
    @RequestMapping("add1")
    public User add(@Validated(value = {New.class}) @RequestBody User user){
        return user;
    }

    /**
     * 只验证没有分组的注解
     * bindingResult 与验证参数紧邻，验证结果会封装在里面，程序不会抛出异常而退出，继续执行下面代码
     * 可以自己根据业务逻辑判断需要怎么处理
     * @param user
     * @return
     */
    @RequestMapping("add2")
    public User add2(@Validated @RequestBody User user, BindingResult bindingResult){
        return user;
    }


    /**
     *  //@Valid 为javax的，@Validated 为spring的，算是增强版
     *  //@Valid 没有分组功能
     *
     * @param user
     * @return
     */
    @RequestMapping("/add3")
    public User add3(@Valid @RequestBody User user){
        return user;
    }

    //若参数内有验证，必须在类上加@Validated，方法上和参数内加都无效
    @RequestMapping("/add4")
    public Integer add4(@RequestParam(value = "id",required = true) @Min(100) Integer id){
        return id;
    }
    //类上的@Validated不会验证此方法
    @RequestMapping("/add5")
    public User add5(@RequestBody User user){
        //自己做验证
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        validate.stream().forEach(v-> System.out.println(v.getMessage()));
        return user;
    }


}
