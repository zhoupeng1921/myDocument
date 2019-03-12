package com.xhx.java;

public class Singleton {

    private static Singleton singleton = new Singleton();
    //在这里值是1   0
    //在连接阶段，准备时 counter1 和 counter2 都是默认值0，
    //在初始化阶段：先初始化singleton，counter1 和 counter2 变为1，
    //再初始化counter1，counter1没有默认值，不变
    //初始化counter2 设置为默认值0

    public static  int counter1;
    public static int counter2 = 0;

    // private static Singleton singleton = new Singleton();
    //在这里返回值是 1 1
    //按照初始化顺序，初始化singleton时，counter2已经赋予默认值0，
    //然后初始化singleton时，在构造方法中加了1

    private Singleton(){
        counter1++;
        counter2++;
    }
    public static Singleton getInstance(){
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.counter1);
        System.out.println(singleton.counter2);
        /**
         * 1
         * 0
         */
    }
}
