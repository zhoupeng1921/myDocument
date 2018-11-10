package com.xhx.java;

import org.junit.Test;

import java.awt.image.VolatileImage;

public class TestThread {

    /**
     * 开启一个线程
     */
    @Test
    public void test01() {
        Thread thread = new Thread();
        //thread.run();//不能开启一个线程，是Runnable的接口的实现
        thread.start();
    }

    /**
     * 1.重写run方法
     *
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("my first thread");
            }
        };
        thread.start();
    }


    /**
     * 2. 给thread一个Runnable接口的实例，赋给target
     * 不需要重写run方法，会调用实例的run方法
     */
    @Test
    public void test03() {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("my second thread");
            }
        }).start();
    }

    /**
     * stop
     * 终止线程
     */
    @Test
    public void test04() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("my first thread");
            }
        };
        //thread.stop(); //不推荐使用，直接中断线程
    }


    /**
     * public void interrupt()
     * 中断线程
     * public boolean isInterrupted()
     * 判断是否被中断
     * public static boolean interrupted()
     * 判断是否被中断并清除中断状态
     */
    @Test
    public void test05() throws Exception {
        Thread thread = new Thread(() -> {
            while (true) {
                //判断线程是否被中断
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("interruted");
                    break;
                }
                Thread.yield();
            }
        });
        thread.start();
        Thread.sleep(2000);
        //中断线程
        thread.interrupt();
    }


    /**
     * sleep 为什么要捕捉异常
     * sleep时，若线程中断，会跑出异常并且清空中断位
     *
     * @throws Exception
     */
    @Test
    public void test06() throws Exception {
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("interruted");
                    break;
                }
                try {
                    System.out.println("1");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("interruted when sleep");
                    //设置中断状态，跑出中断后，这里会清除中断标记位
                    //所以线程不会停止，if判断一直为false
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
        Thread.sleep(8000);
    }


    /**
     * suspend 线程
     * resume 唤醒挂起线程
     * 已经不推荐使用
     *
     * @throws Exception
     */
    @Test
    public void test07() throws Exception {
        Object o = new Object();
        Thread thread = new Thread(() -> {
            synchronized (o) {
                try {
                    Thread.sleep(2000);
                    Thread.currentThread().suspend();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        thread.start();
        //造成线程还没有暂停，就执行唤醒了，线程会一直暂停下去，不会终止
        //被锁住的资源也将会一直锁住
        thread.resume();
        thread.join();
    }

    /**
     * join 等待线程结束
     * 内部原理是wait()等待，线程结束后系统会调用notifyAll()
     * 所以不要在Thread实例上使用wait()和notify()方法
     * <p>
     * yeild 谦让，让出cpu时间片
     */
    volatile int i = 0;

    @Test
    public void test08() throws Exception {

        Thread thread = new Thread(() -> {
            for (i = 0; i < 100000; i++) {
            }
        });
        thread.start();
        thread.join();  //等待线程执行完
        System.out.println(i);
    }


    /**
     * 在后台默默地完成一些系统性的服务，比如垃圾回收线程、jit线程就可以理解为守护线程
     */
    @Test
    public void test09() throws Exception {
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    System.out.println(1);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setDaemon(true);
        t.start();
    }


    /**
     * setPriority
     * 设置线程优先级
     */
    @Test
    public void test10() throws Exception {
        Thread high = new Thread(() -> {
            synchronized (TestThread.class) {
                try {

                    while (true) {
                        System.out.println("哈哈哈");
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {

                }
            }
        });
        Thread low = new Thread(() -> {
            synchronized (TestThread.class) {
                try {
                    while (true) {
                        System.out.println("呜呜呜");
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {

                }
            }
        });
        low.setPriority(Thread.MIN_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);

        low.start();
        high.start();

        Thread.sleep(10000);
    }


    /**
     * synchronized 三种使用方法
     * - 自己指定加锁对象
     * - 作用于实例方法 锁对象就是当前对象
     * - 作用于静态方法 锁对象就是当前类
     */
    @Test
    public void test11() {

    }

    /**
     * wait
     * wait后会自动释放锁，等待其它获取这个锁对象的线程notify后，继续执行
     * 继续执行是有条件的，因为在synchronized里，所以需要重新获得锁，
     * 才能继续执行
     * <p>
     * notify
     * 随机唤醒锁对象上等待线程中的一个
     * notifyAll
     * 唤醒所有等待线程
     * <p>
     * 使用时需要先获得监视器，所以要用在synchronized里
     */
    @Test
    public void test12() throws Exception {
        Object object = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (object) {
                System.out.println("t1 starting");
                try {
                    object.wait();//释放锁 等待唤醒 再获得锁，方可执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1 end");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (object) {
                System.out.println("t2 starting");
                object.notify();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 end");
            }
        });

        t1.start();
        t2.start();

        /**
         * t1 starting
         * t2 starting
         * t2 end
         * t1 end
         */

        Thread.sleep(5000);
    }

}
