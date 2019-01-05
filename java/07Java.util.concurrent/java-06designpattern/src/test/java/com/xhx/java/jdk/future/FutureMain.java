package com.xhx.java.jdk.future;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureMain {

    /**
     * 用 FutureTask
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        FutureTask<String> futureTask = new FutureTask<>(new RealData("a"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(futureTask);
        System.out.println("请求完毕");
        //模拟其它业务逻辑
        Thread.sleep(2000);
        System.out.println("数据：" + futureTask.get());
    }


    /**
     * 不用 FutureTask
     * 直接开启线程执行
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new RealData("b"));
        System.out.println("请求完毕");
        //模拟其它业务逻辑
        Thread.sleep(2000);
        System.out.println("数据：" + future.get());
    }
}
