package com.xhx.java.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUtils {

    /**
     * 循环继承的父类,根据方法名反射
     * @param clazz
     * @param methodName
     * @param parameterTypes
     * @return
     */
    public static Method getDeclaredMethod(Class clazz, String methodName, Class<?>... parameterTypes) {
        Method method = null;
        while (!Object.class.equals(clazz) && method == null) {
            try {
                method = clazz.getDeclaredMethod(methodName, parameterTypes);
            } catch (NoSuchMethodException e) {
            }
            clazz = clazz.getSuperclass();
        }
        return method;
    }

    /**
     * 循环继承的属性,根据方法名反射
     * @param clazz
     * @param fieldName
     * @return
     */
    public static Field getDeclaredField(Class clazz, String fieldName) {
        Field field = null;
        while(!Object.class.equals(clazz) && field == null){
            try {
                field = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
            }
            clazz = clazz.getSuperclass();
        }
        return field;
    }


    public static Object invokeMethod(Object instance, Method method, Object... parameters) {
        try {
            method.setAccessible(true);
            return method.invoke(instance, parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setFieldValue(Object instance,Field field,Object value){
        field.setAccessible(true);
        try {
            field.set(instance,value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getFieldValue(Object instance,Field field){
        field.setAccessible(true);
        try {
            return field.get(instance);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
