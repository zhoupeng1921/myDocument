package com.xhx.java;

import com.xhx.java.entity.User;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Test02Method {
    private Class clazz = User.class;

    /**
     * getMethod()所有的 public方法，包括父类继承的 public
     */
    @Test
    public void test01(){
        Method[] methods = clazz.getMethods();
        Arrays.stream(methods).forEach(method -> {
            System.out.println(method.getName());
        });
    }

    /**
     * 获取该类所有的方法，包括private ,但不包括继承的方法。
     */
    @Test
    public void test02(){
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(method -> {
            System.out.println(method.getName());
        });
    }
}
