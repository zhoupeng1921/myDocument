package com.xhx.java;

import com.xhx.java.entity.User;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * 获取class 以及创建实例
 */
public class Test01Class {


    /**
     *  获取class的三种方式
     */
    @Test
    public void test01(){
        Class<User> userClass = User.class;
    }
    @Test
    public void test02(){
        User user = new User();
        Class<? extends User> aClass = user.getClass();
    }

    /**
     * Class.forName(类的全称);该方法不仅表示了类的类型，还代表了动态加载类。编译时刻加载类是静态加载、运行时刻加载类是动态加载类。
     * @throws ClassNotFoundException
     */
    @Test
    public void test03() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.xhx.java.entity.User");
    }

    /**
     * clazz.newInstance() 已经过时
     *
     * 无法反射的处理构造函数抛出的异常
     *
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Test
    public void test04() throws IllegalAccessException, InstantiationException {
        Class<User> userClass = User.class;
        User user = userClass.newInstance();
    }

    /**
     * 用下面方法代替
     *
     * 可以用InvocationTargetException 捕捉反射时构造函数抛出的异常
     *
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    @Test
    public void test05() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<User> userClass = User.class;
        User user = userClass.getDeclaredConstructor().newInstance();

    }
}
