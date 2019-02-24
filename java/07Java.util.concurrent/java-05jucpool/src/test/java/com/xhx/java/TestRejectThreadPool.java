package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestRejectThreadPool {

    public static class MyTask implements Runnable{
        public MyTask(){
        }

        @Override
        public void run() {
            System.out.println("正在执行Thread:"+Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * RejectedExecutionHandler
     * 自定义拒绝策略
     */
    @Test
    public void test01() throws Exception{
        MyTask task = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString()+" is discard");
                    }
                });
        for(int i = 0; i<Integer.MAX_VALUE;i++){
            es.submit(task);
            Thread.sleep(10);
        }
    }


    /**
     * ThreadPoolExecutor 自带4种拒绝策略，这里举例一种DiscardPolicy，具体看文档
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        AtomicInteger atomicInteger = new AtomicInteger();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, new SynchronousQueue<>(),
                new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                System.out.println("Thread:" + atomicInteger.getAndIncrement());

                try {
                    //模拟正在处理东西
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        Thread.sleep(1000);
        System.out.println("corePoolSize:" + executor.getCorePoolSize());
        System.out.println("poolSize:" + executor.getPoolSize());
        System.out.println("taskCount:" + executor.getTaskCount());

        Thread.sleep(4000);
    }
}
