package com.xhx.java.simple;

import java.util.List;
import java.util.Vector;

public class TestThreadPool {
    private static TestThreadPool instance = null;

    //空闲的线程队列
    private List<Worker> idleThreads;

    //已有线程总数
    private int threadCounter;

    private boolean isShutDown = false;

    private TestThreadPool(){
        this.idleThreads = new Vector<>(5);
        threadCounter = 0;
    }

    public int getCreatedThreadsCount(){
        return threadCounter;
    }
    //取得线程池实例
    public synchronized static TestThreadPool getInstance(){
        if(instance == null){
            instance = new TestThreadPool();
        }
        return instance;
    }

    //将线程放入线程池
    protected synchronized void repool(Worker repoolingThread){
        if(!isShutDown){
            idleThreads.add(repoolingThread);
        }else {
            repoolingThread.shutDown();
        }
    }
    //停止池中所有线程
    public synchronized void shutdown(){
        isShutDown = true;
        for(int threadIndex = 0; threadIndex<idleThreads.size();threadIndex++){
            Worker idleThread = (Worker)idleThreads.get(threadIndex);
            idleThread.shutDown();
        }
    }
    //执行任务
    public synchronized void start(Runnable target){
        Worker thread = null;
        if(idleThreads.size()>0){
            int lastIndex = idleThreads.size()-1;
            thread = (Worker)idleThreads.get(lastIndex);
            idleThreads.remove(lastIndex);
            thread.setTarget(target);
        }else {
            threadCounter++;
            thread = new Worker(target,"PThread #"+threadCounter,this);
            thread.start();
        }
    }
}
