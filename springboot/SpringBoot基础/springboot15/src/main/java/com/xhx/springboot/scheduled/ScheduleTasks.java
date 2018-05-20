package com.xhx.springboot.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * xuhaixing
 * 2018/5/19 20:54
 */
@Component
public class ScheduleTasks {

    /*@Scheduled(fixedRate = 5000)//上一次开始执行时间点之后5s后在执行,经测试，这次线程必须执行完
    public void fixedRateTask() throws Exception{
        System.out.println("我执行了");

        for(Long i = 0L ;i < Long.MAX_VALUE;i++){

        }
        System.out.println("我执行完了");
    }*/

/*    @Scheduled(fixedDelay = 5000)//上一次执行完毕时间点之后5秒再执行
    public void fixedDelayTask() throws Exception{
        System.out.println("我执行了");

        System.out.println("我执行完了");
    }*/

/*    @Scheduled(initialDelay=1000, fixedRate=5000)//第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
    public void fixedInitialTask() throws Exception{
        System.out.println("我执行了");

        System.out.println("我执行完了");
    }*/
    @Scheduled(cron = "0/5 * * * * ?")//上一次执行完毕时间点之后5秒再执行
    public void cronTask() throws Exception{
        System.out.println("我执行了");
        Thread.sleep(5000);
        System.out.println("我执行完了");
    }
}
