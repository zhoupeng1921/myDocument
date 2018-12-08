package com.xhx.java;


import org.junit.Test;

import java.util.ArrayDeque;

/**
 * 方法详情看笔记
 */
public class TestArrayDeque {

    @Test
    public void test01(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(1);
        //offer有返回值
        boolean b1 = arrayDeque.offerFirst(2);

        arrayDeque.addLast(3);
        boolean b2 = arrayDeque.offerLast(4);

        //remove空会抛异常
        Integer integer = arrayDeque.removeFirst();
        Integer integer1 = arrayDeque.removeLast();


        //pool空时，返回null
        Integer first = arrayDeque.pollFirst();
        Integer integer2 = arrayDeque.pollLast();



    }
}
