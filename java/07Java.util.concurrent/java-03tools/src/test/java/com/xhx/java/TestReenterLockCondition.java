package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestReenterLockCondition {


    @Test
    public void test01() throws Exception{
        ReenterLockCondition tlc = new ReenterLockCondition();
        Thread t1 = new Thread(tlc);
        t1.start();
        Thread.sleep(2000);
        //拿到锁
        ReenterLockCondition.lock.lock();
        //通知线程继续执行
        ReenterLockCondition.condition.signal();
        Thread.sleep(3000);
        //释放锁
        ReenterLockCondition.lock.unlock();
        t1.join();
    }
}

/**
 * Condition
 * 与wait/notify类似，需要监视器的支持
 */
class ReenterLockCondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("Thread is awaiting");
            condition.await(); //唤醒后要重新拿到锁，才会继续执行
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
