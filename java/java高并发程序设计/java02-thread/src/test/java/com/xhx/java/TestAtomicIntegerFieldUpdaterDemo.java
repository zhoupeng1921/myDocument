package com.xhx.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class TestAtomicIntegerFieldUpdaterDemo {
    public static class Candidate{
        int id;
        volatile int score;
    }

    public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdater
            = AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");

    public  static AtomicInteger allScore = new AtomicInteger(0);

    int tem = 0;
    @Test
    public void test01(){
        final Candidate stu = new Candidate();
        Thread[] t = new Thread[500];
        for(int i = 0;i < t.length;i++){
            t[i] = new Thread(){
                public void run(){
                    for(int j = 0; j<100;j++) {
                        tem = tem+1;
                        scoreUpdater.incrementAndGet(stu);
                        allScore.incrementAndGet();

                    }
                }
            };
        }
        Arrays.stream(t).forEach(th->th.start());
        Arrays.stream(t).forEach(th-> {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(stu.score);
        System.out.println(allScore.get());
        System.out.println(tem);
        /**
         * 50000
         * 50000
         * 49844
         */
    }
}
