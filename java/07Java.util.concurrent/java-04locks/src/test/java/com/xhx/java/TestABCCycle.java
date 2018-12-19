package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * 线程按序交替打印
 */
public class TestABCCycle {

    @Test
    public void test01() throws Exception{
        Cycle cycle = new Cycle();
        Thread a = new Thread(()->{
            Stream.iterate(0,i -> i = i+1).limit(10).forEach(i->cycle.loopA());
        });
        Thread b = new Thread(()->{
            Stream.iterate(0,i -> i = i+1).limit(10).forEach(i->cycle.loopB());
        });
        Thread c = new Thread(()->{
            Stream.iterate(0,i -> i = i+1).limit(10).forEach(i->cycle.loopC());
        });
        a.start();
        b.start();
        c.start();

        a.join();
        b.join();
        c.join();
    }
}
class Cycle{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(){
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            System.out.print("A");
            number = 2;
            condition2.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
    public void loopB(){
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            System.out.print("B");
            number = 3;
            condition3.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
    public void loopC(){
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            System.out.print("C-");
            number = 1;
            condition1.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}
