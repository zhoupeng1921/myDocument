package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicStampedReference;

public class TestAtomicStampedReference {
    AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19,0);

    @Test
    public void test01() throws Exception{
        for(int i = 0; i<3;i++){
            //获取时间戳，线程里面根据时间戳去充值，只有一个会成功
            final int  timestamp =money.getStamp();
            new Thread(){
                public void run(){
                    while (true){
                        while (true){
                            Integer m = money.getReference();
                            if(m<20){
                                if(money.compareAndSet(m,m+20,timestamp,timestamp+1)){
                                    System.out.println("余额小于20元，充值成功。余额："+money.getReference());
                                    break;
                                }
                            }else {
                                break;
                            }
                        }
                    }
                }
            }.start();
        }

        //消费的线程
        new Thread(){
            public void run(){
                for(int i = 0;i<50;i++){
                    while (true){
                        int timestamp = money.getStamp();
                        Integer m = money.getReference();
                        if(m>10){
                            System.out.println("大于10元");
                            if(money.compareAndSet(m,m-10,timestamp,timestamp+1)){
                                System.out.println("成功消费10元，余额："+money.getReference());
                                break;
                            }
                        }else {
                            System.out.println("没有足够的金额");
                        }
                        try {
                            Thread.sleep(100);
                        }catch (Exception e){

                        }
                    }
                }
            }
        }.start();

        Thread.sleep(10000);
    }
}
