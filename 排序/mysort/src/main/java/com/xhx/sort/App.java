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
    public void bubbleSort() {
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
     * 选择排序
     * 每次比较出最小的，和第一个元素交换和第二个元素交换.,..
     */
    @Test
    public void selectSort() {
        int[] arr = {1, 2, 0, 9, 3, 65, 8, 9, 0, 3, 1, 8, 6, 4, 9};

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
        //[0, 0, 1, 1, 2, 3, 3, 4, 6, 8, 8, 9, 9, 9, 65]
    }


}
