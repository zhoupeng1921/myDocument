package com.xhx.java;

import org.junit.Test;

public class TestThread2 {


    @Test
    public void test2() throws Exception{
        VisibilityTest visibilityTest = new VisibilityTest();
        visibilityTest.start();
        Thread.sleep(2000);
        visibilityTest.change();
        Thread.sleep(5000);


    }


    /**
     * 编译器优化时，可能会造成while条件一直是true
     */
    public class VisibilityTest extends Thread{
        private boolean stop = false;
        public void run(){
            while (!stop){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }

        public void change(){
            stop = true;
        }
    }

}
