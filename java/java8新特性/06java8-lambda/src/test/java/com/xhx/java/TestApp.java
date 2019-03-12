package com.xhx.java;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

public class TestApp {

    public interface MyInterface{
        void sayHello(String name, String content);
    }

    @Test
    public void test01(){
        Function<String,String> f = t->t;
        System.out.println(f.apply("abc"));
    }

    @Test
    public void test02(){
        MyInterface my= (n1,n2)-> System.out.println(n1+n2);
        my.sayHello("a","b");
    }

    public interface  MyLove{
        String getLove();
    }
    @Test
    public void test03(){
        MyLove f = String::new;
        f.getLove();
    }

    @Test
    public void test04(){
        Supplier f = String::new;
        f.get();
    }

    public interface Compare{
        int doCompare(Integer int1, Integer int2);
    }
    @Test
    public void test05(){
        Compare c = Integer::compareTo;
        System.out.println(c.doCompare(1,3));
    }

    public interface Compare2{
        int toInt(String str);
    }
    @Test
    public void test06(){
        Compare2 c = Integer::valueOf;
        System.out.println(c.toInt("3"));
    }
}
