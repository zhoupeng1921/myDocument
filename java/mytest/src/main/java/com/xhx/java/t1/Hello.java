package com.xhx.java.t1;

class A {
    static {
        System.out.print("1");
    }
    {
        System.out.print("3");
    }
    private Integer a = 8;
    public A() {
        System.out.print("2");
        System.out.print(a);
    }
    {
        System.out.print(a);
    }
}

class B extends A {
    static {
        System.out.print("a");
    }

    {
        System.out.print("c");
    }

    public B() {
        System.out.print("b");
    }
}

public class Hello {
    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
        System.out.println("");
        //1a382cb382cb
    }
}
