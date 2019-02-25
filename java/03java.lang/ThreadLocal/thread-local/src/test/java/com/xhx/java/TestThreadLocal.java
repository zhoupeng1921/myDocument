package com.xhx.java;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestThreadLocal {

    @Test
    public void test01() throws Exception{
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>(){
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };
        List<Thread> collect = Stream.iterate(0, i -> i = i + 1).limit(2).map((i) -> {
            return new Thread(() -> {
                threadLocal.set(threadLocal.get() + 1);
                System.out.println("thread:"+Thread.currentThread().getName()+" "+threadLocal.get());
            });
        }).peek(Thread::start).peek(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).collect(Collectors.toList());


        Thread.sleep(1000);
    }

    /**
     * SimpleDateFormat 不是线程安全的，用ThreadLocal解决
     * @throws Exception
     */
    @Test
    public void test02() throws Exception{
        Date date = threadLocalSDF.get().parse("2019-02-25 13:12:12");
        System.out.println(date);
    }
    private static final ThreadLocal<SimpleDateFormat> threadLocalSDF = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
}
