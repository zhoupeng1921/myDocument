package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    @Test
    public void test01() throws Exception{
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println("执行了");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }).start();
        }
        latch.await();
        System.out.println("结束");
    }
}
