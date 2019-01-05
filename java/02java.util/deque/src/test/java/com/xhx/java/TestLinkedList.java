package com.xhx.java;


import org.junit.Test;

import java.util.LinkedList;

/**
 * 方法详情看笔记
 * LinkedList 为用链表实现的
 */
public class TestLinkedList {

    @Test
    public void test01(){
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addFirst("a");
        linkedList.addLast("z");

        String pollFirst = linkedList.pollFirst();
        //空时会抛异常
        String removeFirst = linkedList.removeFirst();


        System.out.println(pollFirst);
        System.out.println(removeFirst);

    }
}
