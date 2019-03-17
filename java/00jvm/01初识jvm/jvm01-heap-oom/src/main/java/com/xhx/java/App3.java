package com.xhx.java;

/**
 * -Xms20m -Xmx60m
 */
public class App3 {
    public static void main(String[] args) {
        //最大可以使用的空间
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024+"m");
        //系统可用的空间(已分配空间中剩余可用空间)
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024+"m");
        //现在分配的空间
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024+"m");

        /**
         * 53m
         * 18m
         * 19m
         */
    }
}
