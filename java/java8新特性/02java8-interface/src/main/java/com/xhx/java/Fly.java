package com.xhx.java;/*
 * Administrator
 * 2018/8/30  11:10
 *
 */

public interface Fly {
    /**
     * java8 接口中可以写静态方法，面向接口编程
     * @return
     */
    static Fly getInstance(){
        return new BirdFly();
    }
    static Fly getInstance2(){
        return new PlanFly();
    }
    void fly();

    /**
     * 接口中可以写default方法，如果动态的添加接口中的方法，
     * 子类就没必要全部实现了，动态添加api方便
     */
    default void wings(){
        System.out.println("翅膀");
    }
}
