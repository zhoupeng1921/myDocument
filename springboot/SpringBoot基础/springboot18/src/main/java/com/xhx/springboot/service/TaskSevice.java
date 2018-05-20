package com.xhx.springboot.service;

import javafx.concurrent.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * xuhaixing
 * 2018/5/20 10:35
 */
@Component
public class TaskSevice {
    private static final Logger logger = LoggerFactory.getLogger(TaskSevice.class);
    //声明异步任务
    @Async
    public void executeAsyncTask1(CountDownLatch countDownLatch ){
        for(int i = 0 ;i<500;i++) {
            logger.info("执行异步任务1:" + i);
        }
        countDownLatch.countDown();
    }

    @Async
    public void executeAsyncTask2(CountDownLatch countDownLatch ){
        for(int i = 0 ;i<500;i++) {
            logger.info("执行异步任务2:" + i);
        }
        countDownLatch.countDown();
    }
}
