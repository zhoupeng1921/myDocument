package com.xhx.designpattern;

/**
 * 真实角色
 */
public class RealSubject implements Subject {
    public void sailBook(String bookName,Double money) {
        System.out.println(bookName+"   "+money+"元");
    }
}
