package com.xhx.java;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Objects;

public class HelloProxy implements MethodInterceptor {

    /**
     * 接口的回调方法
     * @param o  cglib生成的代理对象
     * @param method  被代理的方法
     * @param objects 方法入参
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前");
        System.out.println(method.toString());
        System.out.println(methodProxy.toString());
        System.out.println(o.getClass().toString());
        Object result = methodProxy.invokeSuper(o, objects);

        //这种方法相当于一直调用代理类的方法，在自己的方法中调用自己，就会一直回调，造成死循环
        //Object rest = methodProxy.invoke(o,objects);
        System.out.println("后");
        return result;
    }
    /**
     前
     public void com.xhx.java.Hello.say()
     net.sf.cglib.proxy.MethodProxy@4667ae56
     class com.xhx.java.Hello$$EnhancerByCGLIB$$d156e917
     hello world
     后
     */
}
