package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * 可调度线程池
 */
public class TestScheduledThreadPool {

    /**
     * 延迟3秒执行
     * @throws Exception
     */
    @Test
    public void test01() throws Exception{
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        ScheduledFuture<Integer> result = pool.schedule(() -> {
            return Stream.iterate(1, i -> i = i + 1).limit(100).reduce(0, Integer::sum);
        }, 3, TimeUnit.SECONDS);
        System.out.println(result.get());
        pool.shutdown();
    }
}
