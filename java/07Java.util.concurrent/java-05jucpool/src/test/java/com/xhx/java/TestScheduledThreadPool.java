package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * 可调度线程池
 */
public class TestScheduledThreadPool {

    /**
     * 延迟3秒执行
     *
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        ScheduledFuture<Integer> result = pool.schedule(() ->
                Stream.iterate(1, i -> i = i + 1).limit(100).reduce(0, Integer::sum), 3, TimeUnit.SECONDS);
        System.out.println(result.get());
        pool.shutdown();
    }

    /**
     * schedule 延时执行
     */
    @Test
    public void test02() throws Exception {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
        ScheduledFuture<Integer> resultFuture = executor.schedule(() ->
                Stream.iterate(1, i -> i = i + 1).limit(100).reduce(0, Integer::sum), 3, TimeUnit.SECONDS);
        //5050
        System.out.println(resultFuture.get());
    }


    /**
     * scheduleAtFixedRate 固定频率执行，
     * 可以参考Timer类原理，下次的执行时间是根据这次计算的执行时间算出来的，也就是lastExecuteTime+延时
     */
    @Test
    public void test03() throws Exception {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
        executor.scheduleAtFixedRate(() -> {
            Integer result = Stream.iterate(1, i -> i = i + 1).limit(100).reduce(0, Integer::sum);
            System.out.println(result);
        }, 3, 1, TimeUnit.SECONDS);

        Thread.sleep(20000);
    }

    /**
     * scheduleWithFixedDelay 固定延时执行
     * 可以参考Timer类原理，下次的执行时间是根据这次运行时的时间算出来的，也就是cuttrenTime+延时
     */
    @Test
    public void test04() throws Exception {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
        executor.scheduleWithFixedDelay(() -> {
            Integer result = Stream.iterate(1, i -> i = i + 1).limit(100).reduce(0, Integer::sum);
            System.out.println(result);

        }, 3, 1, TimeUnit.SECONDS);

        Thread.sleep(20000);
    }


}
