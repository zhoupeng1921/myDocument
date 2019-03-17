package com.xhx.java;

/**
 * 测试日志参数
 *
 * -XX:+PrintGCDetails
 *
 */
public class App2 {

    public static void test(){
        byte[] bytes = new byte[1024*1024*2];
    }
    public static void main(String[] args) {

        while (true){
            App2.test();
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
