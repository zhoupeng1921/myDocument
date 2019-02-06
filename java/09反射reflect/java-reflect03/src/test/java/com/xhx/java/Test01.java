package com.xhx.java;

import org.junit.Test;
import org.reflections.Reflections;

import java.util.Set;

/**
 * https://github.com/ronmamo/reflections
 */
public class Test01 {


    /**
     * 扫描指定包下，带有某个注解的类
     */
    @Test
    public void test01(){
        Reflections reflections = new Reflections("com.xhx.java");
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Channel.class);
        classSet.forEach(clazz->{
            System.out.println(clazz);
        });

    }

    /**
     * 扫描某个包下，指定类的子类
     */
    @Test
    public void test02(){
        Reflections reflections = new Reflections("com.xhx.java");
        Set<Class<? extends Ianimal>> subTypesOf = reflections.getSubTypesOf(Ianimal.class);
        subTypesOf.forEach(sub->{
            System.out.println(sub);
        });
    }

}
