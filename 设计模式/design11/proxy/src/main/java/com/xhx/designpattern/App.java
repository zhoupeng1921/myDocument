package com.xhx.designpattern;

/**
 * 自己实现代理
 * 静态代理
 */
public class App {
    public static void main(String[] args) {
        ProxySubject proxySubject = new ProxySubject();
        RealSubject realSubject = new RealSubject();
        proxySubject.setSubject(realSubject);
        proxySubject.sailBook("小金梅",20.00);
    }
}
