package com.xhx.java;

import java.lang.reflect.Proxy;

/**
 * xuhaixing
 * 2018/7/30 21:30
 **/
public class App {
    public static void main(String[] args) {
        IVehical car = new Car();

        IVehical vehical = (IVehical)Proxy.newProxyInstance(car.getClass().getClassLoader(), Car.class.getInterfaces(), new VehicalInvacationHandler(car));
        vehical.run();
        System.out.println(vehical.getClass());
    }
}
