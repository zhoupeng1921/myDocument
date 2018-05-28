package com.xhx.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * acquire()表示需要获取一个许可，当没有许可的时候，线程阻塞，release()表示释放一个许可，
 * 下一个阻塞的线程会获取许可，得到执行，通过信号量可以控制现场并发的个数。
 */
public class App {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            final String temp = "---------"+i+"---------";
            Runnable runnable= new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(temp);
                        semaphore.acquire();
                        Thread.sleep(10000);
                        semaphore.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(runnable);
        }

    }
}
