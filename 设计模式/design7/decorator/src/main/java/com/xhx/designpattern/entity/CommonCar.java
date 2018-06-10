package com.xhx.designpattern.entity;

/**
 * 被装饰者 --最普通的车，都会跑
 */
public class CommonCar implements Car {
    public void run() {
        System.out.println("车会跑");
    }
}
