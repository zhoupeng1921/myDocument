package com.xhx.java;

public class ChildClass extends ParentClass{

        public static String subStaticField = "子类静态变量";
        public MyClass subField = new MyClass("子类非静态");
        public static MyClass myClass = new MyClass("子类静态");

        static {
            System.out.println("子类 静态块初始化");
        }

        {
            System.out.println("子类 非静态块初始化");
        }

        public ChildClass(){
            System.out.println("子类构造器初始化");
        }
    }