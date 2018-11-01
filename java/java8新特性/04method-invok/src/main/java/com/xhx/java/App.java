package com.xhx.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

public class App {

    /**
     * 1.构造器引用
     */
    @Test
    public void test1(){
        App.toString(User::new);
    }

    public static  void toString(Supplier supplier){
        System.out.println(supplier.get().toString());
    }

    /**
     * 2.静态方法引用
     */
    @Test
    public void test2(){
        Arrays.asList("a","b").stream().forEach(User::testStatic);
    }

    /**
     * 特定类对方法引用
     */
    @Test
    public void test3(){
        User user = new User();
        user.setId("123");
        user.setAge(13);
        user.setName("beaufulGirl");
        Optional.of(user).ifPresent(User::printString);
    }

    /**
     * 特定对象对方法引用
     */
    @Test
    public void test4(){
        User user = new User();
        user.setId("123");
        user.setAge(13);
        user.setName("beaufulGirl");

    }
}
