package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

public class TestAtomicReference {

    /**
     * compareAndSet
     * 只能有一个成功
     * @throws Exception
     */
    @Test
    public void test01() throws Exception{
        AtomicReference<String> atomicStr = new AtomicReference<>("abc");
        for(int i = 0; i<10;i++){
            new Thread(()->{
                try {
                    Thread.sleep(Math.abs((int)Math.random()*100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(atomicStr.compareAndSet("abc","def")){
                    System.out.println(Thread.currentThread().getId()+" success");
                }else {
                    System.out.println(Thread.currentThread().getId()+" failure");
                }

            }).start();

        }
        Thread.sleep(3000);
    }
}
