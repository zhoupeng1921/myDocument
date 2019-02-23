package com.xhx.java;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer基本操作示例，具体请看md文档
 */
public class TestTimer {

    @Test
    public void test01() throws Exception{
        Timer timer = new Timer(false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("task1");
            }
        }, 3000);
        Thread.sleep(20000);
    }
    @Test
    public void test02() throws Exception{
        Timer timer = new Timer(false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("task1");
            }
        }, 2000,4000);
        Thread.sleep(20000);
    }


    @Test
    public void test05() throws Exception{
        Timer timer = new Timer(false);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("task1");
            }
        }, 2000,5000);
        Thread.sleep(20000);
    }
}
