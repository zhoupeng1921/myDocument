package com.xhx.java;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {


    /**
     * public CyclicBarrier(int parties)
     * 只有一个参数的构造函数
     * @throws Exception
     */
    @Test
    public void test01() throws Exception{
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for(int i = 0;i<5;i++){
            new Thread(()->{
                try {
                    Thread.sleep(new Random().nextInt(5)*1000);
                    cyclicBarrier.await();
                    doThing();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(6000);
    }

    private void doThing() throws InterruptedException{
        Thread.sleep(new Random().nextInt(3)*1000);
        System.out.println("集合完毕报数："+Thread.currentThread().getName());
    }



    /**
     * public CyclicBarrier(int parties, Runnable barrierAction)
     * 两个参数的构造函数，第二个为线程到齐时执行的接口
     * @throws Exception
     */
    Boolean flag = Boolean.FALSE;
    @Test
    public void test02() throws Exception{

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
            if(flag){
                System.out.println("所有士兵报数完毕");
            }else {
                System.out.println("所有士兵集合完毕");
                flag=Boolean.TRUE;
            }
        });
        for(int i = 0;i<5;i++){
            new Thread(()->{
                try {
                    Thread.sleep(new Random().nextInt(5)*1000);
                    cyclicBarrier.await();
                    doThing();
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(6000);
    }
}
