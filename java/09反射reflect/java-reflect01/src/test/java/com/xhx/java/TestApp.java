package com.xhx.java;

import com.xhx.java.iml.Child;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

public class TestApp {


    /**
     * getFields
     * 可以获取到所有的public字段，包括父类的
     */
    @Test
    public void test01(){
        Field[] fields = Child.class.getFields();
        Arrays.stream(fields).forEach(field -> System.out.println(field.getName()));
    }

    /**
     * 获取所有字段，不包括父类的
     */
    @Test
    public void test02(){
        Field[] fields = Child.class.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> System.out.println(field.getName()));
    }
}
