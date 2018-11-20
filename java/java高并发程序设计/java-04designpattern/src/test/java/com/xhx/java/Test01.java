package com.xhx.java;

/**
 * 不变模式
 * 一个类的内部状态创建后，在整个生命期间都不会发生变化时，就是不变类
 * 不变模式不需要同步
 */
public class Test01 {
}

/**
 * 1. 不变类
 *  确保无子类
 *  确保属性只能赋值一次
 *
 *  java.lang.String
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Short
 */
final class Product{
    private final String no;
    private final String name;
    private final  double price;

    public Product(String no, String name, double price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}