package com.xhx.java;

import org.junit.Test;

/**
 * xuhaixing
 * 2018/6/27 10:27
 */
public class TestApp {

    //四舍五入
    @Test
    public void testRound(){
        System.out.println(Math.round(12.5));  //13
        System.out.println(Math.round(-12.5));   //-12
        System.out.println(Math.round(-12.6));   //-13
    }

    //取整
    @Test
    public void testAbs(){
        System.out.println(Math.abs(12.5));  //12.5
        System.out.println(Math.abs(-12.5));   //12.5
    }


}
