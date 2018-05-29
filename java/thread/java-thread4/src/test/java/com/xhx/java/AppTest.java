package com.xhx.java;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Executors四种线程池
public class AppTest 
{
    private  Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                //Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " run");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private  Runnable myRunnableSleep = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " run");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };


    /**
     *  newCachedThreadPool:创建可缓存的线程池，如果线程池中的线程在60秒未被使用就将被移除，在执行新的任务时，
     *  当线程池中有之前创建的可用线程就重用可用线程，否则就新建一条线程
     * public static ExecutorService newCachedThreadPool() {
     *         return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
     *                                       60L, TimeUnit.SECONDS,
     *                                       new SynchronousQueue<Runnable>());
     *     }
     */
    @Test
    public void testCachedThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();//线程池里面的线程数会动态的变化，并可在线程被重用前重用
        for(int i = 0; i<=20;i++){
            executorService.execute(myRunnable);
        }

        Thread.sleep(100000);
    }
    /*
    运行结果：出现可重用线程
pool-1-thread-2 run
pool-1-thread-1 run
pool-1-thread-3 run
pool-1-thread-3 run
pool-1-thread-2 run
pool-1-thread-4 run
pool-1-thread-3 run
pool-1-thread-1 run
pool-1-thread-2 run
pool-1-thread-4 run
pool-1-thread-3 run
pool-1-thread-2 run
pool-1-thread-1 run
pool-1-thread-5 run
pool-1-thread-4 run
pool-1-thread-6 run
pool-1-thread-7 run
pool-1-thread-8 run
pool-1-thread-9 run
pool-1-thread-10 run
pool-1-thread-11 run
     */


    /**
     * newScheduledThreadPool:创建一个可延迟执行或定期执行的线程池
     */
    @Test
    public void testScheduledThreadPool() throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        //5s第一次执行，之后3秒执行一次
        executorService.scheduleAtFixedRate(myRunnable,5,3,TimeUnit.SECONDS);

        Thread.sleep(20000);
    }

    /**
     *   newSingleThreadExecutor:创建一个单线程的Executor，如果该线程因为异常而结束就新建一条线程来继续执行后续的任务
     */
    @Test
    public void testSingleThreadExecutor() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i = 0; i<=20;i++){
            executorService.execute(myRunnable);
        }
        Thread.sleep(20000);
    }

    /**
     * 创建可重用且固定线程数的线程池，如果线程池中的所有线程都处于活动状态，
     * 此时再提交任务就在队列中等待，直到有可用线程；如果线程池中的某个线程由于异常而结束时，线程池就会再补充一条新线程。
     */
    @Test
    public void testFixedThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i<=20;i++){
            executorService.execute(myRunnableSleep);
        }
        Thread.sleep(200000);
    }
}
