package com.xhx.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

public class App {

    /**
     * 1.构造器引用
     * ClassName::New 相当于 new ClassName()
     * 如果调用时有参数，相当于调用带参的构造函数
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
     * CLassName::static_method =》 CLassName.static_method()
     * 如果调用时有参数，直接放到静态方法的形参中
     */
    @Test
    public void test2(){
        Arrays.asList("a","b").stream().forEach(User::testStatic);
    }

    /**
     * 特定类对方法引用
     * ClassName::instance_method => obj.instance_method(xxx)
     * 调用时参数：第一个参数是实体对象 上面的obj
     * 如果有其他参数，会传到方法中
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
     * instance::instance_method =》instance.instance_method(xxxx);
     * 如果有参数，参数就是方法的参数
     */
    @Test
    public void test4(){
        User user = new User();
        user.setId("123");
        user.setAge(13);
        user.setName("beaufulGirl");
        toString(user::printString);
        
    }
    public interface MyInterface{
        void doSomething();
    }
    public void toString(MyInterface face){
        face.doSomething();
    }
}
