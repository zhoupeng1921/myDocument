package com.xhx.java;

import com.xhx.java.iml.Child;
import com.xhx.java.utils.ReflectUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class App {

    public static void main(String[] args) throws Exception {
        Class<Child> clazz = Child.class;
        Child child = clazz.newInstance();

        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println(declaredMethods.length);
        //0  子类反射不到父类的方法

        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println(declaredFields.length);
        //0  子类反射不到父类的属性

        Method method1 = ReflectUtils.getDeclaredMethod(clazz, "method1");
        Object o = ReflectUtils.invokeMethod(child, method1);
        System.out.println(o);
        //parent1
    }
}
