package com.xhx.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {
    AtomicInteger atoi = new AtomicInteger();
    //int atoi = 0;

    @Test
    public void testAtomicInteger01() throws Exception {

        Thread[] th = new Thread[10];


        for (int i = 0; i < th.length; i++) {
            th[i] = new Thread(() -> {
                for (int k = 0; k < 10000; k++) {
//                    atoi = atoi+1;
                    atoi.incrementAndGet();
                }
            });
        }
        Arrays.stream(th).forEach(t -> t.start());
        Arrays.stream(th).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(atoi);

    }
}
