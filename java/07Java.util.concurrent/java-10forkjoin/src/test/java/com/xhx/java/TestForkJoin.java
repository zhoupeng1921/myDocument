package com.xhx.java;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class TestForkJoin {

    private static Long s = 0L;
    private static Long e = 5000000000L;
    @Test
    public void test01(){
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSumCalculate(s, e);
        Long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗时："+ Duration.between(start,end).toMillis());
    }


    @Test
    public void test02(){
        Instant start = Instant.now();
        Long sum = LongStream.rangeClosed(s, e).parallel().reduce(0L, Long::sum);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗时："+ Duration.between(start,end).toMillis());
    }
    @Test
    public void test03(){
        Instant start = Instant.now();
        Long sum = 0L;
        for(Long i = s;i<=e;i++){
            sum = Long.sum(sum,i);
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗时："+ Duration.between(start,end).toMillis());
    }
}
class ForkJoinSumCalculate extends RecursiveTask<Long>{

    private Long start;
    private Long end;

    //临界值
    private static final long THURSHOLD = 100000L;

    public ForkJoinSumCalculate(Long start,Long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if(length<=THURSHOLD){
            Long sum = 0L;
            for(Long i = start;i<=end;i++){
                sum = Long.sum(sum,i);
            }
            return sum;
        }else {
            Long middle = (start+end)/2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start,middle);
            left.fork(); //进行拆分，同时压入线程队列
            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle+1L,end);
            right.fork();

            return Long.sum(left.join(),right.join());
        }
    }
}
