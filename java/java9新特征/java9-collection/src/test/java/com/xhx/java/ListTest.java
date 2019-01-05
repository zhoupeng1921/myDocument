package com.xhx.java;

import org.junit.Test;

import java.util.List;

public class ListTest {

    /**
     * List.of(...)创建任意参数的不可变集合
     */
    @Test
    public void test1(){
        List<Object> list1 = List.of(12,34,543,765);
        //list1.add(1);
        System.out.println(list1);
    }
}
