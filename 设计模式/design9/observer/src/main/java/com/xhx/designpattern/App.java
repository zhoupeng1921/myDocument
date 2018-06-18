package com.xhx.designpattern;

import com.xhx.designpattern.entity.Person;
import com.xhx.designpattern.observer.BirthdayObserver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Person person = new Person();
        person.addObserver(new BirthdayObserver()); //添加观察者
        person.setName("小红");
        person.setAge(18);

        person.deleteObservers();//删除所有观察者
        person.setAge(19);

    }
}
