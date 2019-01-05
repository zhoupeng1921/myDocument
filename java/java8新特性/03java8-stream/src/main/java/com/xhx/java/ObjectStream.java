package com.xhx.java;/*
 * Administrator
 * 2018/8/30  15:29
 * 以IntStream为例，其它方法看源码
 */

import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    /**
     * mapToObj
     * 把转换成其它类型的Stream流
     */
    @Test
    public void testIntStream4(){
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        Stream<String> stringStream = intStream.mapToObj(String::valueOf);
        stringStream.forEach(System.out::print);
        //12345
    }
}
