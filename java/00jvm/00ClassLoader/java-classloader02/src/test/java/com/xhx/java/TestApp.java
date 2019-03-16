package com.xhx.java;

import org.junit.Test;

public class TestApp {

    @Test
    public void test01() {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        System.out.println(cl);
        while (null != cl) {
            cl = cl.getParent();
            System.out.println(cl);
        }
        /**
         * jdk.internal.loader.ClassLoaders$AppClassLoader@2c13da15
         * jdk.internal.loader.ClassLoaders$PlatformClassLoader@7113b13f
         * null
         */
    }
}
