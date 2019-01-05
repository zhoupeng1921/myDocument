package com.xhx.java;

import org.junit.Test;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 1. 线程池：提供了线程队列，队列中保存着所有等待状态的线程。避免了创建与销毁的额外开销，
 * 提高了响应的速度
 * 2. 线程池的体系结构
 *  java.util.concurrent.Executor: 负责线程的使用与调度的根接口
 *      -- ExecutorService子接口： 负责线程池的主要接口
 *          -- ThreadPoolExecutor: 线程池实现类
 *          -- ScheduledExecutorService: 子接口： 负责线程的调度
 *              -- ScheduledThreadPoolExecutor:
 *                  继承了ThreadPoolExecutor实现了ScheduledExecutorService
 * 3. 工具类：Executors
 *  1. newFixedThreadPool(): 创建固定大小的线程池
 *  2. newCachedThreadPool(): 创建线程池，线程池数量不固定，可根据需求自动的更改数量
 *  3. newSingleTHreadPool(): 创建单个线程池，线程池中只有一个线程
 *
 *  4. newScheduledThreadPool(): 创建固定大小的线程，可以延迟或者定时的执行
 */
public class TestExecutors {
    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(Instant.now() + ": "
                    + Thread.currentThread().getName());
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
        executorService.shutdown();
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
