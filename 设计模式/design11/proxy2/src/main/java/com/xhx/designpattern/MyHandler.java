package com.xhx.designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类必须实现这个接口  InvocationHandler
 */
public class MyHandler implements InvocationHandler {

    //被代理的对象
    private Subject subject;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(proxy.getClass().getName());

        System.out.println("打折");

        Object invoke = method.invoke(subject, args);

        System.out.println("赠代金券");
        return invoke;
    }
}
