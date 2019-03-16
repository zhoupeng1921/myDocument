package com.xhx.java;

import org.junit.Test;

class Parent2{
    static int a = 2;
    static {
        System.out.println("parent2 static block");
    }
}

class Child2 extends Parent2{
    static  int b = 4;
    static {
        System.out.println("Child2 static block");
    }
}

/**
 * 同一个命名空间下，类只初始化一次
 */
public class Test03 {
    static {
        System.out.println("Test static block");
    }

    @Test
    public  void test01() {
        Parent2 parent;
        System.out.println("--------");
        parent = new Parent2();
        System.out.println(Parent2.a);
        System.out.println(Child2.b);
        /**
         * Test static block
         * --------
         * parent2 static block
         * 2
         * Child2 static block
         * 4
         */
    }
}
