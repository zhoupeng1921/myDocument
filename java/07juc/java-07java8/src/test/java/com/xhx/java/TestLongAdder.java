package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

/**
 * 用法类似于AtomicInteger
 * 每次遇到冲突就进行热点隔离
 * 最后算总和
 */
public class TestLongAdder {

    @Test
    public void test01() throws Exception{
        LongAdder longAdder = new LongAdder();
        ExecutorService es = Executors.newFixedThreadPool(20);
        Stream.iterate(0,i-> i = i+1).limit(200).forEach(i->{
            es.submit(()->longAdder.add(1));
        });
        Thread.sleep(2000);
        System.out.println(longAdder.sum());

    }
}
