package com.xhx.java;

import com.xhx.java.deadlock.DeadLockChecker;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestReenterLock {


    @Test
    public void test01() throws Exception {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(ReenterLock.i);
    }

    @Test
    public void test02() throws Exception {
        ReenterLockInt r1 = new ReenterLockInt(1);
        ReenterLockInt r2 = new ReenterLockInt(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(2000);
        DeadLockChecker.check();
        Thread.sleep(1000);
    }

    @Test
    public void test03() throws Exception{
        TimeLock tl = new TimeLock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}

/**
 * ReentrantLock
 * lock
 * 可重入，可以加多次锁，但是也要多次释放
 */
class ReenterLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            lock.lock();
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
                lock.unlock();
            }
        }
    }
}

/**
 * lockInterruptibly
 * 这个锁可以被中断
 */
class ReenterLockInt implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    /**
     * 控制加锁顺序，方便构成死锁
     *
     * @param lock
     */
    public ReenterLockInt(int lock) {
        this.lock = lock;
    }


    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + ":线程退出");
        }
    }
}

/**
 * tryLock
 * 可限时
 */
class TimeLock implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if(lock.tryLock(5, TimeUnit.SECONDS)){
                Thread.sleep(6000);
            }else {
                System.out.println("get lock failed");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if(lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}

/**
 * 公平锁  先来先得到锁
 *  public ReentrantLock(boolean fair)
 *  构造函数传参
 *
 *  需要处理一个排队问题，性能可能差点
 */

