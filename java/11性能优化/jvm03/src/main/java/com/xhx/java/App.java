package com.xhx.java;

public class App {
    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(()->{
                while (true){

                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.stackLeakByThread();
    }

}
