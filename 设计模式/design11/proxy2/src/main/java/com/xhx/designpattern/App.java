package com.xhx.designpattern;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 */
public class App {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        System.out.println(subject.getClass().getName());
        MyHandler myHandler = new MyHandler();
        myHandler.setSubject(subject);

        //由哪个ClassLoader对象来对生成的代理对象进行加载
        //这个代理类要继承的接口
        //把代理类实例与handler关联,当动态代理类在调用方法的时候，会关联到这个对象上，invoke方法
        Subject proxySubject = (Subject)Proxy.newProxyInstance(RealSubject.class.getClassLoader(), subject.getClass().getInterfaces(), myHandler);
        proxySubject.sailBoot("小瓶梅",20.00);
        System.out.println(proxySubject.getClass().getName());

    }
}
