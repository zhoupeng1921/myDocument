package com.xhx.java;

import org.junit.Test;

public class TestApp {


    /**
     * Class.forName 不仅将类加载到了jvm中，还会对类进行解释，执行其中的static块
     * @throws Exception
     */
    @Test
    public void test01() throws Exception{
        Class<?> aClass = Class.forName(User.class.getName());
    }
    //通过参数可以控制，只加载.class文件
    @Test
    public void test011() throws Exception{
        Class<?> aClass = Class.forName(User.class.getName(),false,this.getClass().getClassLoader());

        //aClass.newInstance();
    }

    //ClassLoader只加载class文件
    @Test
    public void test02() throws Exception{
        Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass(User.class.getName());


        //      下面这种方法也一样
//        Class<?> aClass1 = this.getClass().getClassLoader().loadClass(User.class.getName());

    }

}
