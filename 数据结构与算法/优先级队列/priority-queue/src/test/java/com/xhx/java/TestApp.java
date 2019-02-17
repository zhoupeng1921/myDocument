package com.xhx.java;


import org.junit.Test;

import java.util.Arrays;

/**
 * 优先级队列
 * 根据权重决定获取元素的顺序
 * 最大优先级队列 ：权重大的优先取出，权重小的最后取出
 * 最小优先级队列：权重小的优先取出，全重大的最后取出
 * <p>
 * 示例：最大优先级队列
 * <p>
 * 原理 二叉堆结构，最大堆
 * <p>
 * 操作：删除、添加
 * <p>
 * 添加：加入数组末尾，进行上浮操作
 * 删除：删除根结点，把末尾元素移到根结点位置，进行下沉操作
 */
public class TestApp {

    private int[] array = new int[8];
    private int size = 0;

    public void resizePriority() {
        array = Arrays.copyOf(array, (size+1)*2);

    }


    @Test
    public void test01() {
        TestApp testApp = new TestApp();
        testApp.inQueue(1);
        testApp.inQueue(5);
        testApp.inQueue(2);
        testApp.inQueue(9);
        testApp.inQueue(10);
        System.out.println(Arrays.toString(testApp.array));
        System.out.println("出队:"+testApp.outQueue());
        System.out.println("出队:"+testApp.outQueue());
        testApp.inQueue(0);
        testApp.inQueue(9);
        testApp.inQueue(3);
        testApp.inQueue(1);
        testApp.inQueue(8);
        testApp.inQueue(7);
        testApp.inQueue(1);
        System.out.println(Arrays.toString(testApp.array));
        System.out.println("出队:"+testApp.outQueue());
        System.out.println("出队:"+testApp.outQueue());
        System.out.println("出队:"+testApp.outQueue());
        System.out.println("出队:"+testApp.outQueue());

    }

    public void inQueue(int value) {
        if (size + 1 >= array.length) {
            resizePriority();
        }
        array[size++] = value;
        up(array,size-1);
    }

    public int outQueue(){
        if(size<=0){
            throw new RuntimeException("空了");
        }

        int value = array[0];
        array[0] = array[--size];
        down(array,0,size);


        return  value;

    }


    /**
     * 对parentIndex元素进行下沉操作
     *
     * @param array       数组
     * @param parentIndex 非叶子结点
     * @param length      数组长度 即要调整的长度
     */
    public void down(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int leftChildIndex = 2 * parentIndex + 1;
        while (leftChildIndex < length) {
            int rightChildIndex = leftChildIndex + 1;
            int index = leftChildIndex;
            //如果有右孩子，比较出两个最大值
            if (rightChildIndex < length && array[rightChildIndex] > array[index]) {
                index = rightChildIndex;
            }
            if (temp >= array[index]) {
                break;
            }
            array[parentIndex] = array[index];
            parentIndex = index;
            leftChildIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;

    }


    /**
     * 添加元素时，对最后一个元素进行上浮调整
     * @param array 待调整的数组
     * @param index 要上浮的元素位置，从0开始
     */
    public void up(int[] array,int index) {
        int childIndex = index;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

}
