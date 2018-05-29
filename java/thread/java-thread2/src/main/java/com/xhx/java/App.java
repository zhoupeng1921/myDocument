package com.xhx.java;

import java.util.concurrent.CountDownLatch;

/**
 * 多线程-等待其他线程完成CountDownLatch
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
    /*
    主线程等待。。。。。
线程：11开始执行
线程：12开始执行
线程：13开始执行
线程：14开始执行
线程：15开始执行
线程：16开始执行
线程：17开始执行
线程：18开始执行
线程：19开始执行
线程：20开始执行
线程：11执行完毕
线程：12执行完毕
线程：13执行完毕
线程：14执行完毕
线程：18执行完毕
线程：15执行完毕
线程：17执行完毕
线程：16执行完毕
线程：20执行完毕
线程：19执行完毕
主线程执行完毕。。。。。
     */
}
