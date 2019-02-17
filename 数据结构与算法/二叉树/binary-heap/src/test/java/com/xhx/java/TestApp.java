package com.xhx.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestApp {

    /**
     * 构建二叉堆 最大堆
     * 最后一个非叶子结点为(array.length-1)/2
     */
    @Test
    public void testBuildHeap() {
        int[] array = new int[]{0, 8, 1, 2, 6, 8, 4, 2, 10, 3, 70, 99, 33, 7, 99, 10, 50, 30, 4, 8, 1, -5, 60};
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            down(array, i, array.length - 1);
        }
        System.out.println(array[0]);
    }

    /**
     * 每次取出一个最大元素，然后进行堆的下沉操作
     */
    @Test
    public void testDelete() {
        int[] array = new int[]{0, 8, 1, 2, 30, -5, 60};
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            down(array, i, array.length - 1);
        }
        System.out.println(array[0]);
        int length = array.length;
        for (int i = 0; i < length-1; i++) {
            List<Integer> list = new ArrayList<>();
            Arrays.stream(array).forEach(a->list.add(a));
            list.remove(0);
            list.add(0,list.get(list.size()-1));
            list.remove(list.size()-1);

            array = new int[list.size()];
            for(int j =0;j<list.size();j++){
                array[j] = list.get(j);
            }
            down(array, 0, array.length - 1);
            System.out.println(array[0]);
        }

    }


    /**
     * 对parentIndex元素进行下沉操作
     *
     * @param array       数组
     * @param parentIndex 非叶子结点
     * @param maxIndex    数组最后一个索引，为什么要单独一个参数，后面堆排序要用
     */
    public void down(int[] array, int parentIndex, int maxIndex) {
        int temp = array[parentIndex];
        int leftChildIndex = 2 * parentIndex + 1;
        while (leftChildIndex <= maxIndex) {
            int rightChildIndex = leftChildIndex + 1;
            int index = leftChildIndex;
            //如果有右孩子，比较出两个最大值
            if (rightChildIndex <= maxIndex && array[rightChildIndex] > array[index]) {
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
     *
     * @param array
     */
    public void up(int[] array) {
        int childIndex = array.length - 1;
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
