package com.xhx.designpatter;

/**
 * xuhaixing
 * 2018/6/18 18:15
 * 策略的具体实现，不与业务代码在一起，还可以独立演化
 **/
public class MD5Strategy implements Strategy {
    public void encrypt() {
        System.out.println("执行md5加密");
    }
}
