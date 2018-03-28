package cn.itcast.controller;

import cn.itcast.domain.Person;
import cn.itcast.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PersonController {
    @Resource
    private PersonService personService;

    //查询，将查询结果传递到页面
    @RequestMapping("/person/list.action")   //Controller加载时会自动创建加载路径/person/list;/person/list.action
    public String list(Model model){
        List<Person> personList = personService.find(null);
        model.addAttribute("personList",personList);
        return "/person/jPersonList";
    }

    //转向新增页面
    @RequestMapping("/person/tocreate.action")
    public String tocreate(){
        return "/person/jPersonCreate";
    }
    //新增保存
    @RequestMapping("/person/insert.action")
    public String insert(Person person){
        personService.insert(person);
        return "redirect:/person/list.action";
    }


}
