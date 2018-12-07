package com.xhx.java;


import org.junit.Test;

import java.util.ArrayDeque;

public class TestArrayDeque {

    @Test
    public void test01(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);

    }
}
