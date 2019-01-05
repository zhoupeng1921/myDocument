package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Stream;

/**
 * 1. 读写锁
 * 写写/读写 互斥
 * 读读 不需要互斥
 */
public class TestReadWriteLock {

    @Test
    public void test01() throws Exception {
        ReadWriteLockDemo lockDemo = new ReadWriteLockDemo();
        Stream.iterate(0, i -> i = i + 1).limit(50).forEach(i -> {
            Thread readTh = new Thread(() -> lockDemo.get());
            Thread writeTh = new Thread(() -> lockDemo.set());
            readTh.start();
            writeTh.start();
        });

        Thread.sleep(2000);
        lockDemo.get();
    }

}

class ReadWriteLockDemo {
    private int number = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    //读
    public void get() {
        lock.readLock().lock();
        try {
            System.out.println(number);
        } finally {
            lock.readLock().unlock();
        }
    }

    //写
    public void set() {
        lock.writeLock().lock();
        try {
            this.number++;
        } finally {
            lock.writeLock().unlock();
        }
    }
}