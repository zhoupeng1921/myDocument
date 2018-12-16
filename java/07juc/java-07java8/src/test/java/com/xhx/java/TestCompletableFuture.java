package com.xhx.java;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class TestCompletableFuture {


    /**
     * 完成后通知
     * @throws Exception
     */
    @Test
    public void test01() throws Exception{
        CompletableFuture<Integer> cf = new CompletableFuture<>();
        new Thread(new AskThread(cf)).start();
        Thread.sleep(2000);
        cf.complete(10);
    }

    /**
     * supplyAsync 有返回值
     * runAsync 没返回值
     * 异步执行
     * @throws Exception
     */
    @Test
    public void test02() throws Exception{
        CompletableFuture<Integer> cf = CompletableFuture
                .supplyAsync(()->{
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 10*10;});

        System.out.println(cf.get());
    }

    /**
     * 函数式编程
     * @throws Exception
     */
    @Test
    public void test03() throws Exception{
        CompletableFuture<Void> cf = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 10 * 10;
                })
                .thenCompose((i)-> CompletableFuture
                        .supplyAsync(()->i*i))
                .thenApply(i -> i.toString() + "abc")
                .thenAccept(System.out::println);
        cf.get();
    }


}
class AskThread implements Runnable{

    CompletableFuture<Integer> cf = null;
    public AskThread(CompletableFuture<Integer> cf){
        this.cf = cf;
    }

    @Override
    public void run() {
        int myRe = 0;
        try {
            myRe = cf.get()*cf.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(myRe);
    }
}