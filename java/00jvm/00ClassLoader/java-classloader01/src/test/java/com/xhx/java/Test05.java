package com.xhx.java;

import org.junit.Test;

class CL{
    static {
        System.out.println("Class C");
    }
}

public class Test05 {

    @Test
    public void test01() throws Exception{
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("com.xhx.java.CL");
        System.out.println("-----------");

        clazz = Class.forName("com.xhx.java.CL");
        /**
         * -----------
         * Class C
         */

    }
}
