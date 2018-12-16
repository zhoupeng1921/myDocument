package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * Semaphore 信号量
 * 允许多个线程进入临界区
 */
public class TestSemaphore {

    @Test
    public void test01() throws Exception{
        Semaphore semaphore = new Semaphore(5);
        for(int i = 0;i<15;i++){
            new Thread(()->{
                try {
                    //一个线程也可以获取多个许可 acquire(2)
                    // tryAcquire(）
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"：获得信号量");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }
        Thread.sleep(5000);
    }
}
