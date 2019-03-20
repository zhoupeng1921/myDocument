package com.xhx.java;

/**
 * 死锁代码
 */
public class App {

    private static A a = new A();
    private static B b = new B();

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(()->{
            synchronized (a){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println("第一个线程执行了");
                }
            }

        });
        Thread t2 = new Thread(()->{
            synchronized (b){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println("第二个线程执行了");
                }
            }

        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
class A{

}

class B{

}