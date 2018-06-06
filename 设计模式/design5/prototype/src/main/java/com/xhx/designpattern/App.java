package com.xhx.designpattern;

import com.xhx.designpattern.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型设计模式
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person person = new Person();
        person.setName("小小");
        person.setAge(25);
        List<String> cars = new ArrayList<>();
        cars.add("宝马");
        cars.add("奔驰");
        person.setCars(cars);
        System.out.println(person);


        //Person clonePerson = person.clone();  //默认浅克隆，复制的引用，没有对属性创建新的对象
        Person clonePerson = person.clone2();  //深克隆
        cars.add("野马");
        System.out.println(clonePerson);
        /**
         * Person{name='小小', age=25, cars=[宝马, 奔驰]}
         * Person{name='小小', age=25, cars=[宝马, 奔驰, 野马]}
         */
        /**
         * Person{name='小小', age=25, cars=[宝马, 奔驰]}
         * Person{name='小小', age=25, cars=[宝马, 奔驰]}
         */


    }
}
