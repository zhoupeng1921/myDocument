package com.xhx.java;

import org.junit.Test;

import java.util.ArrayList;
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
     * Function<T, R> 过滤
     */
    @Test
    public void testSorted(){
//        List<String> filterList = list.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList());
        List<String> filterList = list.stream().sorted(Comparator.comparing(String::toString)).collect(Collectors.toList());
        filterList.stream().forEach(System.out::print);
    }

}
