package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock 读写锁
 * 读读不互斥
 * 读写互斥
 * 写写互斥
 */
public class TestReadWriteLock {

    @Test
    public void test01() throws Exception{
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i =0;i<5;i++) {
            executor.execute(new ReadWriteLock());
        }
        Thread.sleep(5000);
    }

}

class ReadWriteLock implements Runnable{
    public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    public static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    @Override
    public void run() {
        try {
            readLock.lock();
            System.out.println("read");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("over");
            readLock.unlock();
        }
    }
}