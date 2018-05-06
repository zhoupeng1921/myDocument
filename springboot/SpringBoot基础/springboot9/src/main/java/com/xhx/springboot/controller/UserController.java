package com.xhx.springboot.controller;


import com.google.common.base.Preconditions;
import com.xhx.springboot.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "user")
public class UserController {
    public static List<User> users = new ArrayList<>();
    static {
        User user1 = new User();
        user1.setName("小红");
        user1.setAge(25);
        user1.setId("1");
        users.add(user1);

        User user2 = new User();
        user2.setName("小白");
        user2.setAge(26);
        user2.setId("2");
        users.add(user2);
    }

    @ApiOperation(value = "获取用户列表",notes = "用户列表接口")
    @RequestMapping(value = "getList", method = RequestMethod.POST)
    public List<User> getUserList(){
        return users;
    }

    @ApiOperation(value = "创建用户",notes = "创建用户")
    @ApiImplicitParam(name = "User",value = "用户实体",required = true,dataType = "User")
    @RequestMapping(value = "createUser", method = RequestMethod.POST)
    public List<User> createUser(@RequestBody User user){
        users.add(user);
        return users;
    }

    /**
     * path 代表在url中
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id获取用户",notes = "获取单个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "String",paramType = "path")
    })
    @RequestMapping(value = "{id}",method = RequestMethod.POST)
    public User getUser(@PathVariable(value = "id") String id){
        for(int i=0;i< users.size();i++){
            if(users.get(i).getId().equals(id)){
                return users.get(i);
            }
        }
        return null;
    }

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String  helloWord() {
        return "忽略";
    }
}
