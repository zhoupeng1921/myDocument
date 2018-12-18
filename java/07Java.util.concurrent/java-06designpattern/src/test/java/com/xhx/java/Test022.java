package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者基本模型，
 * ReentrantLock  实现等待唤醒机制
 */
public class Test022 {

    @Test
    public void test1() throws Exception{
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Salor salor = new Salor(clerk);
        Thread th1 = new Thread(productor);
        Thread th2 = new Thread(salor);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
    }
}

class Clerk{
    private int product = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public  void get(){
        lock.lock();
        try {
            while (product>=1){
                System.out.println("产品已满");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName()+": "+ ++product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void sale(){
        lock.lock();
        try {
            while (product<=0){
                System.out.println("产品缺货");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName()+": "+ --product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 生产者
 */
class Productor implements Runnable{
    private Clerk clerk;
    public Productor(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        for(int i = 0;i<20;i++){
            this.clerk.get();
        }

    }
}

class Salor implements Runnable{
    private Clerk clerk;
    public Salor(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for(int i = 0;i<20;i++) {
            this.clerk.sale();
        }
    }
}