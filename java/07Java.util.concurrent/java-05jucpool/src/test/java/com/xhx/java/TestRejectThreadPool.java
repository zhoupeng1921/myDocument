package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.*;

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
     * 拒绝策略
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
}
