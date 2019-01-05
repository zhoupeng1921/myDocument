package com.xhx.java;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Optional;

public class App {

    @Test
    public void test1(){
        //不允许为空，返回Optional
        Optional.of("abc");
        //允许为空 返回Optional
        Optional.ofNullable("abc");
        //获取数据
        System.out.println(Optional.ofNullable("abc").get());//abc
        //判断是否为空，返回true or false
        System.out.println(Optional.ofNullable(null).isPresent());//false
        // ifPresent(Consumer consumer)  如果值存在调用传入的函数
        Optional.ofNullable("abc").ifPresent(System.out::println); //abc

        //orElse(T vlaue),如果值不存在，返回value值
        String str = (String)Optional.ofNullable(null).orElse("hahaha");
        System.out.println(str); //hahaha

        //orElseGet(Supplier<? extends T> other)
        str = "abcde";
        str = (String) Optional.ofNullable(null).orElseGet(str::toUpperCase);
        System.out.println(str);//ABCDE
        //filter map flatMap与stream流用法一样


    }
}
