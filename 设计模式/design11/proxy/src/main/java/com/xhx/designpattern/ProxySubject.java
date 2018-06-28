package com.xhx.designpattern;

import java.util.Objects;

/**
 * 代理角色，要接收真实的角色，
 * 然后再进行进一步封装
 */
public class ProxySubject implements Subject{

    private Subject subject;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void sailBook(String bookName, Double money) {
        if(Objects.isNull(subject)){
            subject = new RealSubject();
        }
        System.out.println("打折");
        subject.sailBook(bookName,money);
        System.out.println("返优惠券");
    }
}
