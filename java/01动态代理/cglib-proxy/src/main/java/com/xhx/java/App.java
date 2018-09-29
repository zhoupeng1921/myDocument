package com.xhx.java;

public class App {

    public static void main(String[] args) {
        Hello hello = (Hello)ProxyBuilder.getHelloProxy(Hello.class, new HelloProxy());
        hello.say();
    }
}
