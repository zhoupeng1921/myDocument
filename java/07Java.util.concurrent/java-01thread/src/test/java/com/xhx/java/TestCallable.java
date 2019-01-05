package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.stream.Stream;


/**
 * Callable创建线程，1 有返回值  2 可以抛出异常，
 * 执行时需要FutureTask实现类支持
 * get时会阻塞
 */
public class TestCallable {


    @Test
    public void test01() throws Exception{
        ThreadDemo td = new ThreadDemo();
        FutureTask<Integer> task = new FutureTask<>(td);
        new Thread(task).start();
        Integer integer = task.get();
        System.out.println(integer);


    }
}
class ThreadDemo implements Callable<Integer>{


    @Override
    public Integer call() throws Exception {
        return Stream.iterate(1,i->i=i+1).limit(100000000).reduce(0,Integer::sum);
    }
}
