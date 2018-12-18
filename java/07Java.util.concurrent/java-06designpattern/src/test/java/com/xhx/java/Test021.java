package com.xhx.java;

import org.junit.Test;

/**
 * 生产者消费者基本模型，
 * synchronized  实现等待唤醒机制
 */
public class Test021 {

    @Test
    public void test1() throws Exception{
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Salor salor = new Salor(clerk);
        Thread th1 = new Thread(productor,"生产者A");
        Thread th2 = new Thread(salor,"消费者A");
        th1.start();
        th2.start();
        th1.join();
        th2.join();
    }
    class Clerk{
        private int product = 0;

        public synchronized void get(){
            while (product>=1){
                System.out.println("产品已满");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+": "+ ++product);
            this.notifyAll();
        }

        public synchronized void sale(){
            while (product<=0){
                System.out.println("产品缺货");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+": "+ --product);
            this.notifyAll();
        }
    }

    /**
     * 生产者
     */
    class Productor implements Runnable{
        private Clerk clerk;
        public Productor(Clerk clerk){
            this.clerk = clerk;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            for(int i = 0;i<20;i++){
                this.clerk.get();
            }

        }
    }

    class Salor implements Runnable{
        private Clerk clerk;
        public Salor(Clerk clerk){
            this.clerk = clerk;
        }

        @Override
        public void run() {
            for(int i = 0;i<20;i++) {
                this.clerk.sale();
            }
        }
    }
}

/**
 * 多个生产者消费者时存在虚假唤醒问题，所以用在while中，别用在if中
 */
