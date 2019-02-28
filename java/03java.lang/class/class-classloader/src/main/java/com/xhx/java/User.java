package com.xhx.java;

public class User {
    private static String str = test02();
    private String str2 = test03();
    static {
        System.out.println("静态代码块执行");
    }
    {
        System.out.println("普通代码块执行");
    }

    public User(){
        System.out.println("构造方法执行");
    }

    public static void test01(){
        System.out.println("静态方法1执行");
    }

    public static String test02(){
        System.out.println("静态方法2执行");
        return "aaa";
    }

    public String test03(){
        System.out.println("非静态方法2执行");
        return "aaa";
    }

}
