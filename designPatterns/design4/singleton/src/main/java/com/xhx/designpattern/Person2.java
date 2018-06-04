package com.xhx.designpattern;

import java.util.Objects;

public class Person2 {
    private String name;

    //构造函数私有化
    private Person2(){}

    //懒汉式  多线程中不可以保证是一个对象
    private static Person2 person ;

    //提供一个全局的静态方法
    public static Person2 getPerson(){
        if(Objects.isNull(person)){
            person=new Person2();
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
