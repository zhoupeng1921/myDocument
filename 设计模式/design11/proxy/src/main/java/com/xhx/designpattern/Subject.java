package com.xhx.designpattern;

/**
 * 抽象角色
 * 真实对象与代理对象都需要实现的接口
 */
public interface Subject {
    void sailBook(String bookName,Double money);
}
