package com.xhx.designpattern;

public class Person {
    private String name;

    //构造函数私有化
    private Person(){}

    //饿汉式  多线程中可以保证是一个对象
    private static final Person person = new Person();

    //提供一个全局的静态方法
    public static Person getPerson(){
        return person;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
