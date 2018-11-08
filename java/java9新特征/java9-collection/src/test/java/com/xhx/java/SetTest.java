package com.xhx.java;

import org.junit.Test;

import java.util.List;
import java.util.Set;

public class SetTest {

    /**
     * Set.of(...)创建任意参数的不可变集合
     */
    @Test
    public void test1() {
        Set<Object> set1 = Set.of(12, 34, 543, 765);
        //list1.add(1);
        System.out.println(set1);
    }
}
