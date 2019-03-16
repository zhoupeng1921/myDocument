package com.xhx.java;

import org.junit.Test;

class Parent3{
    static int a = 3;
    static {
        System.out.println("parent static block");
    }
    static void doSomething(){
        System.out.println("do something");
    }
}
class Child3 extends Parent3{
    static {
        System.out.println("child static block");
    }
}

/**
 * 通过子类访问父类的成员，不会初始化子类
 */
public class Test04 {

    @Test
    public void test01(){
        //Child3根本就没有初始化
        System.out.println(Child3.a);
        /**
         * parent static block
         * 3
         */
    }
}
