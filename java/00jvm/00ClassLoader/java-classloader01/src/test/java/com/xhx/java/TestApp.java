package com.xhx.java;

import org.junit.Test;

public class TestApp {

    @Test
    public void test01() throws Exception{
        Class<?> aClass = Class.forName("java.lang.String");
        System.out.println(aClass.getClassLoader());
        //null  根类加载器加载

        System.out.println(this.getClass().getClassLoader());
        //jdk.internal.loader.ClassLoaders$AppClassLoader@512ddf17
        //应用类加载器加载
    }
}

