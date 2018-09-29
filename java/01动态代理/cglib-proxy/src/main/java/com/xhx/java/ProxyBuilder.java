package com.xhx.java;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

public class ProxyBuilder {
    public static Object getHelloProxy(Class clazz, Callback callback) {
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(clazz);
        //设置回调类 拦截方法  MethodInterceptor的 intercept方法
        enhancer.setCallback(callback);
        //生成代理对象
        return enhancer.create();
    }
}
