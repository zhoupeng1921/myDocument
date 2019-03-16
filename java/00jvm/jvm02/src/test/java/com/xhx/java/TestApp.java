package com.xhx.java;

import org.junit.Test;

public class TestApp {

    @Test
    public void test01(){
        long maxMemory = Runtime.getRuntime().maxMemory();//返回java虚拟机试图使用的最大内存容量
        long totalMemory = Runtime.getRuntime().totalMemory();//返回java虚拟机中的内存总量
        System.out.println(maxMemory/1024/1024);
        System.out.println(totalMemory/1024/1024);

    }
}
