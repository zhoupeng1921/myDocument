package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport 挂起线程
 *
 * park与unpark
 * 哪怕unpark发生在park之前，线程也不会被阻塞住
 *
 * park会响应中断，也会继续执行，不抛出异常，
 * 可以从Thread.interrupted()得到中断标志
 */
public class TestLockSupport {
    public static Object obj = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("T1");
    static ChangeObjectThread t2 = new ChangeObjectThread("T2");


    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name){
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (obj){
                System.out.println("in "+getName());
                LockSupport.park();
                //park会响应中断，也会继续执行
            }
        }
    }

    @Test
    public void test01() throws Exception{
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t2);
        LockSupport.unpark(t1);
        t1.join();
        t2.join();
    }
}
