package com.xhx.springboot.tokenbucket;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TokenBucket {

    RateLimiter rateLimiter = RateLimiter.create(10);//QPS = 10

    public void doRequest(){
        if(rateLimiter.tryAcquire()){
            System.out.println(Thread.currentThread().getName()+" success");
        }else {
            System.out.println(Thread.currentThread().getName()+" error");
        }
        System.out.println("QPS="+rateLimiter.tryAcquire());
    }

    public static void main(String[] args) throws Exception{
        TokenBucket tokenBucket = new TokenBucket();

        CountDownLatch countDownLatch = new CountDownLatch(1);
        Random random = new Random(10);
        for(int i = 0; i<20;i++){
            new Thread(()->{
                try {
                    countDownLatch.await();
                    Thread.sleep(random.nextInt(1000));
                    tokenBucket.doRequest();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            },"name"+i).start();
        }
        countDownLatch.countDown();
        System.in.read();
    }
}
