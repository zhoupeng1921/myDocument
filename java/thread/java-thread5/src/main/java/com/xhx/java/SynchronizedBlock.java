package com.xhx.java;

/**
 * xuhaixing
 * 2018/6/30 17:29
 **/
public class SynchronizedBlock {
    public void method1() {
        System.out.println("method1--start");
        try {
            synchronized (this) {
                System.out.println("method1--executing");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method1--end");
    }

    public void method2() {
        System.out.println("method2--start");
        synchronized (this) {
            System.out.println("method2--executing");
        }
        System.out.println("method2--end");
    }

    public static void main(String[] args) {
        final SynchronizedBlock sync = new SynchronizedBlock();
        new Thread(() -> sync.method1()).start();
        new Thread(() -> sync.method2()).start();
    }
    /**
     method1--start
     method1--executing
     method2--start
     method1--end
     method2--executing
     method2--end
     */
}
