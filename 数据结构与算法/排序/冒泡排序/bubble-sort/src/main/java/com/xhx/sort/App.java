package com.xhx.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


    }

    /**
     * 冒泡排序
     * 原理：
     * 第一次循环选出最大的 然后第二大的
     */
    @Test
    public void bubbleSort0() {
        int[] arr = {1, 2, 0, 9, 3, 65, 8, 9, 0, 3, 1, 8, 6, 4, 9};
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        //[0, 0, 1, 1, 2, 3, 3, 4, 6, 8, 8, 9, 9, 9, 65]
    }

    /**
     * 优化1
     * 有可能在排序的过程中就已经有序了，没必要按部就班的两个for都循环完
     * 如果是下面这种情况，根本就没必要都循环一遍
     * 方案：
     * 加一个标志，在某次循环中，没有发现交换位置的情况，就已经有序了，跳出最外层for循环
     */
    @Test
    public void bubbleSort2() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 9, 8};
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            boolean isSorted = true; //每次大循环开始初始化
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    isSorted = false; //有变动，证明还无序
                }
            }
            if (isSorted) { //没变动，证明已有序
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 优化2
     * 在冒泡排序中，有序区的长度和排序的轮数时相等的，第一次 一个最大值（一个有序） 第二次 次最大值（两个有序）
     * 实际排序时，真正的有序区可能会比排序的轮数长
     * <p>
     * 方案：
     * 把最后一次排序的位置记下来，即无序数组的边界，那个位置以后的数据就都是有序的
     */
    @Test
    public void bubbleSort3() {
        int[] arr = {4, 3, 2, 1, 5, 6, 7, 9, 8};
        int len = arr.length;
        int unSortedBorder = len - 1;
        int lastExchangeIndex=0;
        for (int i = 0; i < len - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < unSortedBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    isSorted = false;
                    lastExchangeIndex=j;
                }
            }
            unSortedBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }



}
