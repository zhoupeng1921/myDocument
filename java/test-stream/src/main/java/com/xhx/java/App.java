package com.xhx.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * parallelStream 在循环时，若需要把循环的值赋到外面的集合中，外面集合必须是安全的或者设置同步，否则多线程会读取到集合的同一个下标，造成值缺少
     * List<String> collect1 = Collections.synchronizedList( new ArrayList<>()); 使用同步集合
     *
     * 若在循环时，不影响外面的变量，可以随便用，不能操作外部不安全的变量，可能会出问题
     */

    @Test
    public void test1() throws Exception{
        for(int i= 0;i<1000;i++){
            testPaStream1();
        }
    }

    /**
     * 不安全
     */
    @Test
    public void testPaStream1() throws Exception{
        List<String> list = new ArrayList<>();
        for(int i = 0; i <20;i++){
            list.add("a");
        }
        List<String> collect1 = new ArrayList<>();
        List<String> collect = list.parallelStream().map(str->{
            collect1.add(str);return str;}).collect(Collectors.toList());
        System.out.println(collect1.size()+"   "+collect.size());
    }

    /**
     * 安全  Collections.synchronizedList
     */
    @Test
    public void testPaStream11() throws Exception{
        List<String> list = new ArrayList<>();
        for(int i = 0; i <20;i++){
            list.add("adbcdad");
        }
        List<String> collect1 = Collections.synchronizedList( new ArrayList<>());
        List<String> collect = list.parallelStream().map(str->{collect1.add(str);return str;}).collect(Collectors.toList());
        System.out.println(collect1.size()+"   "+collect.size());
    }


    /**
     * 不安全
     */
    @Test
    public void testPaStream2() throws Exception{
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> listOfIntegers =Arrays.asList(intArray);
        List<Integer> parallelStorage = new ArrayList<>();//Collections.synchronizedList(new ArrayList<>());
        listOfIntegers.parallelStream().map(e -> {
                    parallelStorage.add(e);
                    return e;
                }).forEachOrdered(e -> System.out.print(e + " "));
        System.out.println();
        parallelStorage.stream().forEachOrdered(e -> System.out.print(e + " "));
        System.out.println();
//        System.out.println("Sleep 5 sec");
//        TimeUnit.SECONDS.sleep(5);
//        parallelStorage
//                .stream()
//                .forEachOrdered(e -> System.out.print(e + " "));
    }

    @Test
    public void testPaStream3() throws Exception{
        List<String> list = new ArrayList<>();
        for(int i = 0; i <25000000;i++){
            list.add("adbcdad");
        }
       // List<String> strings = Collections.synchronizedList(new ArrayList<>()); //安全
        List<String> strings = new ArrayList<>(); //不安全
        long startTime = System.currentTimeMillis();
        List<String> collect = list.stream().map(String::toUpperCase).peek(strings::add).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"    "+strings.size());

    }

}
