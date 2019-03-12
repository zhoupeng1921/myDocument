package com.xhx.java;

import org.junit.Test;

import java.util.Random;

class FinalTest {
    //编译时常量
    public static final  int X = 6/3;

    static {
        System.out.println("hahaha");
    }

}
class FinalTest2 {
    //运行时常量
    public static final  int X = new Random().nextInt(100);

    static {
        System.out.println("hahaha");
    }

}

class FinalTest3 {
    public static   int X = 3;

    static {
        System.out.println("hahaha");
    }

}
public class Test01{

    @Test
    public void test01(){
        System.out.println(FinalTest.X);
        /**
         * 2
         */
    }

    @Test
    public void test02(){
        System.out.println(FinalTest2.X);
        /**
         * hahaha
         * 26
         */
    }

    @Test
    public void test03(){
        System.out.println(FinalTest3.X);
        /**
         * hahaha
         * 3
         */
    }
}
