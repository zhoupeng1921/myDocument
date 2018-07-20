package com.xhx.java;

/**
 * xuhaixing
 * 2018/7/20 21:43
 **/
public class Student {
    private String name;
    private String sex;
    private double money;

    public Student(String name, String sex, double money) {
        this.name = name;
        this.sex = sex;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", money=" + money +
                '}';
    }
}
