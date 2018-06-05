package com.xhx.designpattern.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person implements Cloneable{
    private  String name;
    private int age;
    private List<String> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    @Override
    public Person clone() {
        try {
            return (Person)super.clone(); //浅拷贝
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public Person clone2() {
        try {
            //深拷贝
            Person clone = (Person) super.clone();
            List<String> cars2 = new ArrayList<>();
            cars2.addAll(this.getCars());
            clone.setCars(cars2);
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
