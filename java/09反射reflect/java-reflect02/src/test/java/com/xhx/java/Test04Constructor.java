package com.xhx.java;

import com.xhx.java.entity.User;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class Test04Constructor {
    private Class clazz = User.class;

    /**
     * 获取本类public构造函数
     */
    @Test
    public void test01(){
        Constructor[] constructors = clazz.getConstructors();
        Arrays.stream(constructors).forEach(constructor -> {
            System.out.println(constructor.getName());
        });
    }

    /**
     * 获取本类所有构造函数
     */
    @Test
    public void test02(){
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        Arrays.stream(declaredConstructors).forEach(constructor -> {
            System.out.println(constructor.getName());
        });
    }
}
