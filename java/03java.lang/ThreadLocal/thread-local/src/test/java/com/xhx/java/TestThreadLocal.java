package com.xhx.java;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 原理： ThreadLocal内部有一个ThreadLocal.ThreadLocalMap  KEY 是ThreadLocal value是值
 * 每一个Thread内部有一个threadLocals属性，为ThreadLocal.ThreadLocalMap类型，同一个ThreadLocal不同的线程，获取的ThreadLocalMap不一样
 * ThreadLocal.ThreadLocalMap 里有一个Entry[] table类型的数组
 * 数组的下标threadLocal.threadLocalHashCode & (table.length - 1)这么得来的，如果冲突会后移
 *
 * 注意：如果ThreadLocal设置的值是多线程共享的，依旧有线程安全问题。
 *
 * 应用场景：同一事务下的connection
 */
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


    /**
     * 不同的ThreadLocal，获取的都是Thread.currentThread()的ThreadLocalMap
     * @throws Exception
     */
    @Test
    public void test03() throws Exception{
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(100);
        threadLocal.set(200);
        ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
        threadLocal2.set("aaa");

        System.out.println(threadLocal.get());
        System.out.println(threadLocal2.get());
    }

    /**
     * 如果操作的数据是多线程共享的引用类型，也会是非线程安全的
     * @throws Exception
     */
    @Test
    public void test04() throws Exception{
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        List<ThreadLocal> threadLocalList = Collections.synchronizedList(new ArrayList<>());
        new Thread(()->{
            ThreadLocal<List> threadLocal = new ThreadLocal<>();
            threadLocal.set(list);
            list.add(100);
            threadLocalList.add(threadLocal);
            System.out.println(threadLocal.get());
        }).start();

        new Thread(()->{
            ThreadLocal<List> threadLocal = new ThreadLocal<>();
            list.add(200);
            threadLocal.set(list);
            threadLocalList.add(threadLocal);
            System.out.println(threadLocal.get());
        }).start();

        Thread.sleep(1000);
    }
}
