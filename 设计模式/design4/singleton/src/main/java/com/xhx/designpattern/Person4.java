package com.xhx.designpattern;

import java.util.Objects;

public class Person4 {
    private String name;

    //构造函数私有化
    private Person4(){}

    //懒汉式  多线程中不可以保证是一个对象
    private static Person4 person ;

    //提供一个全局的静态方法
    // 解决方案，同步代码块，双重验证
    public static Person4 getPerson(){
        if(Objects.isNull(person)){
            synchronized (Person4.class) {
                if(Objects.isNull(person)) {
                    person = new Person4();
                }
            }
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
