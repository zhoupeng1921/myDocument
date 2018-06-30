package com.xhx.java;

/**
 * xuhaixing
 * 2018/6/30 17:29
 **/
public class SynchronizedStaticMethod {
    public static synchronized void method1(){
        System.out.println("method1--start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method1--end");
    }
    public static synchronized void method2(){
        System.out.println("method2--start");
        System.out.println("method2--end");
    }

    public static void main(String[] args) {
        new Thread(() ->
                SynchronizedStaticMethod.method1()).start();
        new Thread(() ->
                SynchronizedStaticMethod.method2()).start();
    }
    /**
     * method1--start
     * method1--end
     * method2--start
     * method2--end
     */
}
