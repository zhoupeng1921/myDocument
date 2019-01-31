package com.xhx.sort;


import org.junit.Test;

import java.util.Arrays;

/**
 * 填坑法，递归
 * 基准元素默认选地一个，先移动右指针，再移动左指针，
 * 每找到一个元素，就把它放入坑中，这个元素的位置就变成了新的坑的位置
 *，然后再换另一测指针移动
 */

public class App {



    @Test
    public void testQuickSort(){
        int[] array = {1,0};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }
    public void quickSort(int[] arr, int startIndex, int endIndex){
        if(startIndex>=endIndex){
            return;
        }

        //基准位置默认地一个元素
        int pivot = arr[startIndex];
        int left = startIndex+1; //这里+1了，下面的while都应该加上=条件，否则两个元素就出问题了
        int right = endIndex;
        //要填的坑的位置
        int index = startIndex;

        while (right>=left) {
            //右指针循环左移
            while (left <= right) {
                if (arr[right] <= pivot) { //遇到比基准元素小的，填入坑的位置，移动左指针
                    arr[index] = arr[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }

            //左指针循环右移
            while (left <= right) {
                if (arr[left] > pivot) { //遇到比基准元素大的，填入坑的位置，移动右指针
                    arr[index] = arr[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        //把开始定义的基准元素填入坑，pivot左侧就是小的，右侧就是大的，index就是分割点
        arr[index]=pivot;

        quickSort(arr,startIndex,index-1);
        quickSort(arr,index+1,endIndex);

    }
}
