package com.xhx.java;

import org.junit.Test;

/**
 * xuhaixing
 * 2018/6/28 21:07
 **/
public class TestStringAndBufferAndBuilder {

    /**
     * 内部在执行是new StringBuiler 然后append,然后toString   所以是最慢的
     */
    @Test
    public void testString(){
        long begin = System.currentTimeMillis();
        String str ="";
        for(int i = 0;i<50000;i++){
            str+="hello";
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin); //8499
    }

    /**
     * 最快的
     */
    @Test
    public void testBuilderString(){
        long begin = System.currentTimeMillis();
        StringBuilder str =new StringBuilder();
        for(int i = 0;i<500000;i++){
            str.append("hello");
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin); //47
    }

    /**
     * 线程安全的，第二快
     */
    @Test
    public void testBufferString(){
        long begin = System.currentTimeMillis();
        StringBuffer str =new StringBuffer();
        for(int i = 0;i<500000;i++){
            str.append("hello");
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin); //78
    }
}
