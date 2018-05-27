package com.xhx.java;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池规则
 * <p>
 * 线程池的线程执行规则跟任务队列有很大的关系。
 * <p>
 * 下面都假设任务队列没有大小限制：
 * 如果线程数量<=核心线程数量，那么直接启动一个核心线程来执行任务，不会放入队列中。
 * 任务队列是SynchronousQueue的时候，线程池会创建新线程执行任务，这些任务也不会被放在任务队列中。这些线程属于非核心线程，在任务完成后，闲置时间达到了超时时间就会被清除，线程池满会异常
 * 当任务队列是LinkedBlockingDeque，会将超过核心线程的任务放在任务队列中排队。也就是当任务队列是LinkedBlockingDeque并且没有大小限制时，线程池的最大线程数设置是无效的，他的线程数最多不会超过核心线程数。
 * 如果线程数量>核心线程数，并且>最大线程数，当任务队列是SynchronousQueue的时候，会因为线程池拒绝添加任务而抛出异常。
 * <p>
 * 任务队列大小有限时
 * 当LinkedBlockingDeque塞满时，新增的任务会直接创建新线程来执行，当创建的线程数量超过最大线程数量时会抛异常。
 * SynchronousQueue没有数量限制。因为他根本不保持这些任务，而是直接交给线程池去执行。当任务数量超过最大线程数时会直接抛异常。
 */
public class AppTest {
    static Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    //核心线程数为6，最大线程数为10。超时时间为5秒
    @Test
    public void testSyncQueue() {

        //每个任务都是是直接启动一个核心线程来执行任务，一共创建了6个线程，不会放入队列中

        ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 10, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        executorTest(executor);
        /**
         * ---先开三个---
         * 核心线程数6
         * 线程池数3
         * 队列任务数0
         * ---再开三个---
         * 核心线程数6
         * 线程池数6
         * 队列任务数0
         * pool-1-thread-2 run
         * pool-1-thread-4 run
         * pool-1-thread-1 run
         * pool-1-thread-5 run
         * pool-1-thread-3 run
         * pool-1-thread-6 run
         * ----8秒之后----
         * 核心线程数6
         * 线程池数6
         * 队列任务数0
         */
    }

    //核心线程数为3，最大线程数为6。超时时间为5秒,队列是LinkedBlockingDeque
    @Test
    public void testLinkedQueue() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        executorTest(executor);
        /**
         * ---先开三个---
         * 核心线程数3
         * 线程池数3
         * 队列任务数0
         * ---再开三个---
         * 核心线程数3
         * 线程池数3
         * 队列任务数3
         * pool-1-thread-2 run
         * pool-1-thread-1 run
         * pool-1-thread-3 run
         * pool-1-thread-3 run
         * pool-1-thread-1 run
         * pool-1-thread-2 run
         * ----8秒之后----
         * 核心线程数3
         * 线程池数3
         * 队列任务数0
         */
    }

    // 线程数是3，最大线程数是4，队列是LinkedBlockingDeque
    @Test
    public void testlinkedQueue2() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        executorTest(executor);
        /**
         * ---先开三个---
         * 核心线程数3
         * 线程池数3
         * 队列任务数0
         * ---再开三个---
         * 核心线程数3
         * 线程池数3
         * 队列任务数3
         * pool-1-thread-2 run
         * pool-1-thread-1 run
         * pool-1-thread-3 run
         * pool-1-thread-1 run
         * pool-1-thread-3 run
         * pool-1-thread-2 run
         * ----8秒之后----
         * 核心线程数3
         * 线程池数3
         * 队列任务数0
         */
    }

    //LinkedBlockingDeque有大小限制时就会受最大线程数影响了
    @Test
    public void testLinkedBlock3() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(2));
        executorTest(executor);
    }

    //核心线程数是3 ，最大线程数是4，队列是SynchronousQueue
    @Test
    public void testSync2() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        executorTest(executor);
        /**
         * 这次在添加第五个任务时就报错了，因为SynchronousQueue各奔不保存任务，收到一个任务就去创建新线程。所以第五个就会抛异常了。
         */
    }

    public void executorTest(ThreadPoolExecutor executor) {
        try {
            executor.execute(myRunnable);
            executor.execute(myRunnable);
            executor.execute(myRunnable);
            System.out.println("---先开三个---");
            System.out.println("核心线程数" + executor.getCorePoolSize());
            System.out.println("线程池数" + executor.getPoolSize());
            System.out.println("队列任务数" + executor.getQueue().size());
            executor.execute(myRunnable);
            executor.execute(myRunnable);
            executor.execute(myRunnable);
            System.out.println("---再开三个---");
            System.out.println("核心线程数" + executor.getCorePoolSize());
            System.out.println("线程池数" + executor.getPoolSize());
            System.out.println("队列任务数" + executor.getQueue().size());
            Thread.sleep(8000);
            System.out.println("----8秒之后----");
            System.out.println("核心线程数" + executor.getCorePoolSize());
            System.out.println("线程池数" + executor.getPoolSize());
            System.out.println("队列任务数" + executor.getQueue().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


