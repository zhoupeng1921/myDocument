package com.xhx.java;

import org.junit.Test;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestExecutors {
    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(Instant.now() + ":Thread ID:"
                    + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * newFixedThreadPool 固定线程池
     */
    @Test
    public void test01() throws Exception {
        MyTask task = new MyTask();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            //submit会返回一个Future类型对象
            //executorService.submit(task);
            executorService.execute(task);
        }
        Thread.sleep(3000);
    }


    /**
     * newScheduledThreadPool
     * 固定任务的线程池
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        //如果前面任务没有完成，则调度也不会启动
        //上一个运行完后，再等两秒钟，运行下一个
        executorService.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Instant.now().toEpochMilli() / 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 2, TimeUnit.SECONDS);

        Thread.sleep(10000);
/**
 * 1542514244
 * 1542514247
 */
    }
}
