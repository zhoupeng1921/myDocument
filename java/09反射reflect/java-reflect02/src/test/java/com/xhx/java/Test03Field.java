package com.xhx.java;

import com.xhx.java.entity.User;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Test03Field {
    private Class clazz = User.class;

    /**
     * getFields 获取所有public属性，包括父类继承的public
     */
    @Test
    public void test01(){
        Field[] fields = clazz.getFields();
        Arrays.stream(fields).forEach(field -> {
            System.out.println(field.getName());
        });
    }

    /**
     * 获取该类所有属性，包括private，不包括父类继承的
     */
    @Test
    public void test02(){
        Field[] declaredFields = clazz.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> {
            System.out.println(field.getName());
        });
    }

}
