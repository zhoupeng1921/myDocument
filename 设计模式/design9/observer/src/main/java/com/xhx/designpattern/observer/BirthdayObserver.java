package com.xhx.designpattern.observer;

import com.xhx.designpattern.entity.Person;

import java.util.Observable;
import java.util.Observer;

/**
 * xuhaixing
 * 2018/6/18 23:35
 *
 * 观察者，需要继承 java.util.Observer 这个类
 **/
public class BirthdayObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Person person = (Person)arg;
        System.out.println("祝 "+person.getName() +" " +person.getAge() + "岁生日快乐");
    }
}
