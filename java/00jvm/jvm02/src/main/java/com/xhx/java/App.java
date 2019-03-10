package com.xhx.java;

/**
 * 栈内存容量
 *  -Xss180k
 */
public class App {

    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) {
        App app = new App();
        try {
            app.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length："+ app.stackLength);
            throw e;
        }
        /**
         * stack length：1551
         * Exception in thread "main" java.lang.StackOverflowError
         * 	at com.xhx.java.App.stackLeak(App.java:11)
         */
    }

}
