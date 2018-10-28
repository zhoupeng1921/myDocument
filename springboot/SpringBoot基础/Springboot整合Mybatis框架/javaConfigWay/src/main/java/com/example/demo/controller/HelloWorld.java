package com.example.demo.controller;

import com.example.demo.bean.Cat;
import com.example.demo.config.ConfigBean;
import com.example.demo.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Configuration
public class HelloWorld {

    @Value("${com.xuhaixing.name}") //绑定配置文件中的属性
    private String name;

    @Autowired
    ConfigBean configBean;

    @Autowired
    private CatService catService;

    @RequestMapping("/hello")
    public String helloWorld(){
        return "helloworld!!!"+name+",sex:"+configBean.getSex()+",all"+configBean.getAll();
    }

    @RequestMapping("/add")
    public String add(Cat cat){
        try {
            catService.insert(cat);
            return "添加成功";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "添加失败";
        }
    }
    @RequestMapping("/update")
    public String update(Cat cat){
        try {
            catService.update(cat);
            return "更新成功";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "更新失败";
        }
    }
    @RequestMapping("/delete")
    public String delete(int id){
        try {
            catService.delete(id);
            return "删除成功";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "删除失败";
        }
    }
    @RequestMapping("/selectone")
    public Object selectone(int id){
        try {
            return catService.select(id);

        }catch (Exception e){
            e.printStackTrace();
            return "查询失败";
        }
    }
}