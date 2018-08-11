package com.xhx.java;

class ParentClass{
        public static String parentStaticField = "父类静态变量";
        public MyClass parentField = new MyClass("父类非静态");
        public static MyClass myClass = new MyClass("父类静态");

        static {
            System.out.println("父类 静态块初始化");
        }

        {
            System.out.println("父类 非静态块初始化");
        }

        public ParentClass(){
            System.out.println("父类  构造器初始化");
        }
    }