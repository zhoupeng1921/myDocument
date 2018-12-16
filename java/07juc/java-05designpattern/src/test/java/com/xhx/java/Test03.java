package com.xhx.java;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者模型
 */
public class Test03 {
    private BlockingDeque<PCData> queue = new LinkedBlockingDeque<>();
    private AtomicInteger count = new AtomicInteger(0);
    private boolean isRunning = true;
    private Random r = new Random(1000);
    private final int SLEEPTIME = 1000;
    @Test
    public void test01() throws Exception{
        for(int i = 0;i<5;i++) {
            new Thread(() -> {
                try {
                    while (isRunning) {
                        Thread.sleep(SLEEPTIME*6);
                        PCData data = new PCData(count.incrementAndGet());
                        System.out.println(data + "is put into queue");
                        //向队列中赋值
                        if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                            System.out.println("failed to put data: " + data);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }


        while (true){
            //拿不到会阻塞
            PCData data = queue.take();
            if(null!=data){
                int re = data.getData()* data.getData();
                System.out.println(re);
            }
        }
    }
}




/**
 * 数据体
 */
class PCData{
    private Integer data;
    public PCData(Integer data){
        this.data = data;
    }

    public Integer getData() {
        return data;
    }
}
