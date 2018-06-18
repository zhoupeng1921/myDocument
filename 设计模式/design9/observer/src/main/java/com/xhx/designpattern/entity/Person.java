package com.xhx.designpattern.entity;

import java.util.Observable;

/**
 * xuhaixing
 * 2018/6/18 23:31
 *
 * Person类作为被观察者，需要继承java.util.Observable这个类
 **/
public class Person extends Observable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    /**
     * 当姓名改变的时候，通知观察者
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
        this.setChanged();   //标记为改变了
        this.notifyObservers(this); //通知观察者，可以传参数也可以不传
    }
}
