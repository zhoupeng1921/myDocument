package com.xhx.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 数据量特别大时Iterator比for快10倍，不知道什么原因
 */
public class ArrayListTest {
    @Test
    public void test01() {
        //存储一些数据到集合中
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            arrayList.add(i);
        }
        System.out.println("for遍历ArrayList：" + arrayListFor(arrayList));
        System.out.println("Iterator遍历ArrayList：" + arrayListIterator(arrayList));
    }
    //使用for循环遍历ArrayList
    public long arrayListFor(List<Integer> arrayList) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
    //使用Iterator遍历ArrayList
    public long arrayListIterator(List<Integer> arrayList) {
        long start = System.currentTimeMillis();
        for (Iterator i = arrayList.iterator(); i.hasNext();) {
            i.next();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}