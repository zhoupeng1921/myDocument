package com.xhx.springboot.scheduled;

import com.xhx.springboot.service.TaskSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * xuhaixing
 * 2018/5/20 10:56
 */
@Component
public class taskScheduled {
    @Autowired
    private TaskSevice taskSevice;

    /**
     * 要等主线程完了，子线程再结束(若程序不终止，主线程结束，子线程还会执行的)
     * @throws Exception
     */
    @Scheduled(cron = "5 * * * * ?")
    public void testTask() throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(2);
        taskSevice.executeAsyncTask1(countDownLatch);
        taskSevice.executeAsyncTask2(countDownLatch);

        System.out.println("主线程执行完了");
        countDownLatch.await();
        System.out.println("等待完毕");
    }
}
