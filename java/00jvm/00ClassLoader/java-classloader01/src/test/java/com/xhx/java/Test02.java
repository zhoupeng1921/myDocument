package com.xhx.java;

class Parent{
    static  int a = 1;
    static {
        System.out.println("parent static block");
    }
}
class Child extends Parent{
    static int b = 4;
    static {
        System.out.println("Child static block");
    }
}

public class Test02 {
    static {
        System.out.println("Test static block");
    }

    public static void main(String[] args) {
        System.out.println(Child.b);
        /**
         * Test static block
         * parent static block
         * Child static block
         * 4
         */
    }
}
