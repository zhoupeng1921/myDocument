package com.xhx.java;

import java.util.concurrent.TimeUnit;

/**
 * while会一直执行，内存的不一致性
 * volatile可以保证内存的可见性
 */
public class App2 {
    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        new Thread(demo).start();
        while (true){
            if(demo.isFlag()){
                System.out.println("-----------结束了");
                break;
            }
        }

    }
}

class ThreadDemo implements Runnable{

    private boolean flag = false;

    @Override
    public void run() {
        System.out.println("------------开始");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setFlag(true);
        System.out.println("------------改变了");
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
