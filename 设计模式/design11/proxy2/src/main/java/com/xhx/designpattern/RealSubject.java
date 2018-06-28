package com.xhx.designpattern;

/**
 * 被代理的类
 */
public class RealSubject implements Subject {
    public void sailBoot(String bookName, Double money) {
        System.out.println(bookName+" "+money+"元");
    }
}
