package com.xhx.designpattern;

import java.util.Objects;

public class Person3 {
    private String name;

    //构造函数私有化
    private Person3(){}

    //懒汉式  多线程中不可以保证是一个对象
    private static Person3 person ;

    //提供一个全局的静态方法  解决方案，使用同步方法
    //缺点：影响效率
    public static synchronized Person3 getPerson(){
        if(Objects.isNull(person)){
            person=new Person3();
        }
        return person;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
