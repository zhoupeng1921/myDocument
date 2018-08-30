package com.xhx.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * xuhaixing
 * 2018/7/5 18:44
 **/
public class testStream {
    static List<String> list = new ArrayList<>();
    static {
        for(int i = 0; i <20;i++){
            list.add("a");
            list.add("b");
        }
    }

    /**
     * map方法，里面是Function<T, R>
     */
    @Test
    public void testMap(){
        List<String> upperList = list.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
        upperList.stream().forEach(System.out::print);
    }

    /**
     * Predicate<T>  过滤
     */
    @Test
    public void testFilter(){
        List<String> filterList = list.stream().filter(str->str.equals("a")).collect(Collectors.toList());
        filterList.stream().forEach(System.out::print);
    }

    /**
     * Function<T, R> 排序
     */
    @Test
    public void testSorted(){
//        List<String> filterList = list.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList());
        List<String> filterList = list.stream().sorted(Comparator.comparing(String::toString).reversed())
                .collect(Collectors.toList());
        filterList.stream().forEach(System.out::print);
    }

    /**
     * forEach forEachOrdered
     */
    @Test
    public void testForEach(){
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5", "6");
        strings.parallelStream().forEach(System.out::print);
        System.out.println();
        strings.parallelStream().forEachOrdered(System.out::print);
    }

    /**
     * reduce,可以设置初始值，然后把循环里面的值当参数，进行处理，返回一个结果
     */
    @Test
    public void testReduce(){
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5", "6");
        String str = strings.stream().reduce("0",(first,second)->first+second);
        System.out.println(str);
    }
}
