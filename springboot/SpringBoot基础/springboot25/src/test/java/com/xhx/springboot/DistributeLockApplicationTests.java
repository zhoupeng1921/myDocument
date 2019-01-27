package com.xhx.springboot;

import com.xhx.springboot.lock.RedissonDistributedLocker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DistributeLockApplicationTests {

    @Autowired
    private RedissonDistributedLocker redissonLocker;

    /**
     * 不同线程会等待
     * @throws Exception
     */
    @Test
    public void contextLoads() throws Exception {
        int count = 10;
        String lockKey = "17631703221";
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(() -> {
                try {

                    System.out.println("===加锁===" + Thread.currentThread().getName());
                    boolean b = redissonLocker.tryLock(lockKey, TimeUnit.SECONDS, 40, 30);
                    if(b){
                        System.out.println("加锁成功");
                        System.out.println("===做自己操作===");
                    }else {
                        System.out.println("加锁失败");
                    }

                    Thread.sleep(2000);

                   // System.out.println("===释放锁===" + Thread.currentThread().getName());
                    //redissonLocker.unlock(lockKey);

                    System.out.println(latch.getCount());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();
            });
            thread.start();

        }
        latch.await();
        Thread.sleep(30);
    }

    /**
     * 相同线程可重入
     * @throws Exception
     */
    @Test
    public void contextLoads2() throws Exception {
        int count = 10;
        for (int i = 0; i < count; i++) {
            try {
                String lockKey = "17631703221";
                boolean b = redissonLocker.tryLock(lockKey, TimeUnit.SECONDS, 100, 100);
                System.out.println(b+"===加锁===" + Thread.currentThread().getName());

                System.out.println("===做自己操作===");
                Thread.sleep(2000);

               // System.out.println("===释放锁===" + Thread.currentThread().getName());
               // redissonLocker.unlock(lockKey);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        Thread.sleep(100000);
    }

}
