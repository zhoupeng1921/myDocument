package com.xhx.sort;


import org.junit.Test;

import java.util.Arrays;

/**
 * 指针交换法，递归
 */

public class App2 {


    @Test
    public void testQuickSort() {
        int[] array = {1, 0};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    public void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        //基准位置默认地一个元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (right > left) {
            //右指针循环左移
            while (left < right && arr[right] > pivot) {
                right--;
            }

            //左指针循环右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if(left<right){
                int tem = arr[left];
                arr[left] = arr[right];
                arr[right] = tem;
            }

        }
        //基准位置与重合时left与right交换
        int tem = arr[left];
        arr[left]  = arr[startIndex];
        arr[startIndex] = tem;


        quickSort(arr, startIndex, left - 1);
        quickSort(arr, left + 1, endIndex);

    }
}
