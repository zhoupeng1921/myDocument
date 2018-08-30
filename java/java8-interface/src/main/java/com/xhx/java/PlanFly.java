package com.xhx.java;/*
 * Administrator
 * 2018/8/30  13:44
 *
 */

public class PlanFly implements Fly,Other {
    @Override
    public void fly() {
        System.out.println("飞机飞");
    }

    /**
     * 可以重写defalut方法
     * 可以显示指定调用哪个
     */
    @Override
    public void wings() {
       Other.super.wings();
    }
}
