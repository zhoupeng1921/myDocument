package com.xhx.java.simple;

public class Worker extends Thread {
    private TestThreadPool pool;
    private Runnable target;
    private boolean isShutDown = false;
    private boolean isIdle = false;

    public Worker(Runnable target, String name, TestThreadPool pool) {
        super(name);
        this.pool = pool;
        this.target = target;
    }

    public TestThreadPool getPool() {
        return pool;
    }

    public void setPool(TestThreadPool pool) {
        this.pool = pool;
    }

    public Runnable getTarget() {
        return target;
    }


    public boolean isShutDown() {
        return isShutDown;
    }

    public void setShutDown(boolean shutDown) {
        isShutDown = shutDown;
    }

    public boolean isIdle() {
        return isIdle;
    }

    public void setIdle(boolean idle) {
        isIdle = idle;
    }

    public void run(){
        while (!isShutDown){
            isIdle = false;
            if(target!=null){
                //运行任务
                target.run();
            }
            //任务结束了
            isIdle = true;
            try {
                //任务关闭后
                pool.repool(this);
                synchronized (this){
                    //线程空闲，等待新的任务到来
                    wait();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            isIdle = false;
        }
    }
    public synchronized void setTarget(Runnable target) {
        this.target = target;
        //设置了任务后，通知run方法，开始执行这个任务
        notifyAll();
    }
    public synchronized void shutDown(){
        isShutDown = true;
        notifyAll();
    }
}
