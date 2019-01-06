package com.xhx.waitnotity;

import org.junit.Test;

/**
 * xuhaixing
 * 2018/7/29 9:21
 **/
public class TestApp {

    @Test
    public synchronized void testWait() {
        System.out.println(Thread.currentThread().getName() + "testWait-start-----");
        try {
            wait(2000);//等待2000毫秒，若不加参数，则一直等待，直到被notity唤醒
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "testWait-end-----");
    }


    @Test
    public void testWaitMain() throws Exception {
        TestApp testApp = new TestApp();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> testApp.testWait(), "thread" + i).start();
        }

        Thread.sleep(5000);
    }


    @Test
    public synchronized void testWait2() {
        System.out.println(Thread.currentThread().getName() + "testWait-start-----");
        try {
            wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "testWait-end-----");
    }

    @Test
    public void testNotityMain() throws Exception {
        TestApp testApp = new TestApp();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> testApp.testWait2(), "thread" + i).start();
        }
        Thread.sleep(1000);
        synchronized (testApp) {
            testApp.notify();
        }
        Thread.sleep(3000);
        System.out.println("---------");
        synchronized (testApp) {
            testApp.notifyAll();
        }
        Thread.sleep(5000);
    }


}
