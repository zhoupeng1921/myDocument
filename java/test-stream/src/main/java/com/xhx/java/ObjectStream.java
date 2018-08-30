package com.xhx.java;/*
 * Administrator
 * 2018/8/30  15:29
 *
 */

import org.junit.Test;

import java.util.stream.IntStream;

public class ObjectStream {

    /**
     * rang 范围
     */
    @Test
    public void testIntStream(){
        IntStream.range(0,5).forEach(System.out::print);
        //01234
    }
    /**
     * rang 范围
     */
    @Test
    public void testIntStream2(){
        IntStream.rangeClosed(0,5).forEach(System.out::print);
        //012345
    }

    /**
     * iterate   一个生成东西的工厂
     */
    @Test
    public void testIntStream3(){
        IntStream iterate = IntStream.iterate(1, e -> e + 1);
        iterate.limit(5).forEach(System.out::print);
        //12345
    }
}
