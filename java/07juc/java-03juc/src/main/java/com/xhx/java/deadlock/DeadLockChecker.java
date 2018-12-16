package com.xhx.java.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadLockChecker {

    private final static ThreadMXBean mbean  = ManagementFactory.getThreadMXBean();
    final static Runnable deadLockCheck = new Runnable() {
        @Override
        public void run() {
            while (true){
                long[] deadLockedThreadIds = mbean.findDeadlockedThreads();
                if(deadLockedThreadIds!=null){
                    ThreadInfo[] threadInfos = mbean.getThreadInfo(deadLockedThreadIds);
                    for(Thread t : Thread.getAllStackTraces().keySet()){
                        for(int i = 0;i<threadInfos.length;i++){
                            if(t.getId()==threadInfos[i].getThreadId()){
                                t.interrupt();
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){

                }
            }
        }
    };


    public static void check(){
        Thread t = new Thread(deadLockCheck);
        t.setDaemon(true);
        t.start();
    }
}
