package com.xhx.java;

/**
 * xuhaixing
 * 2018/8/11 22:03
 **/
public class  App {
    private volatile int i = 0;
    public void testIncrease(){
        i++;
    }

    /**
     * volatile 可以保证可见性、有序性，没法保证原子性
     * @param args
     */
    public static void main(String[] args) {
        final App app = new App();
        for(int i = 0;i<10;i++){
            new Thread(()->{
                for (int j = 0;j<1000;j++){
                    app.testIncrease();
                }
                System.out.println(app.i);
            }).start();
        }
        /*
         * 1000
         * 2279
         * 3000
         * 4094
         * 4809
         * 5809
         * 6809
         * 7809
         * 8809
         * 9809
         */

    }

}
