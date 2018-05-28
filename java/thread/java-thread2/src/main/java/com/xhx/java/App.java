package com.xhx.java;

import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        int threadCount=10;
        final CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i=0; i<threadCount;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程："+Thread.currentThread().getId()+"开始执行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程："+Thread.currentThread().getId()+"执行完毕");
                    latch.countDown();
                }
            }).start();
        }
        try {
            System.out.println("主线程等待。。。。。");
            latch.await();
            System.out.println("主线程执行完毕。。。。。");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
