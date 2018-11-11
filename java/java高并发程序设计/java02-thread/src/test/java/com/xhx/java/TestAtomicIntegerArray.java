package com.xhx.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class TestAtomicIntegerArray {
    static AtomicIntegerArray arr = new AtomicIntegerArray(10);
    public class AddThread implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i<10000;i++){
                arr.getAndIncrement(i%arr.length());
            }
        }
    }

    @Test
    public void test01(){
        Thread[] th = new Thread[10];
        for(int i = 0; i<th.length;i++){
            th[i] = new Thread(new AddThread());
        }
        Arrays.stream(th).forEach(t->t.start());
        Arrays.stream(th).forEach(t-> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(arr);
//        [10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000]
    }
}
