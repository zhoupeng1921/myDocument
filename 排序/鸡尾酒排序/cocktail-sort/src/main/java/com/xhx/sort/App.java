package com.xhx.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    /**
     *  鸡尾酒排序，改自冒泡排序，
     *  解决问题：某个小元素在右侧，可快速的移动到左侧，使元素有序平衡
     *  如下面实例，而不用跟冒泡排序似的，每次都用大循环取排序移动 第一次9和1，第二次8和1，第三次7和1...
     */
    @Test
    public void testCocktailSort() {
        int[] array={2,3,4,5,6,7,8,9,1};

        for(int i =0; i< array.length/2;i++){
            boolean isSorted = true; //标记是否已经有序
            //从左到右的循环
            for(int j = i; j<array.length-i-1;j++){
                if (array[j] > array[j+1]) {
                    int tem = array[j];
                    array[j]=array[j+1];
                    array[j+1] = tem;
                    isSorted=false;
                }
            }
            if(isSorted){
                break;
            }
            //从右到左的循环
            isSorted=true;
            for(int j = array.length-i-1;j>i;j--){
                if(array[j]<array[j-1]){
                    int tem = array[j];
                    array[j]=array[j-1];
                    array[j-1] = tem;
                    isSorted=false;
                }
            }
            if(isSorted){
                break;
            }
        }

        System.out.println(Arrays.toString(array));
    }


    /**
     * 和冒泡排序一样，针对有序区优化，记录最后一次变换的位置，为无序区最后一个位置
     */
    @Test
    public void testCocktailSort2() {
        int[] array={2,3,4,5,6,7,8,9,1};
        int lastRightExchangeIndex=0;
        int lastLeftExchangeIndex=0;
        int rightUnsortBorder = array.length-1;
        int leftUnsortBorder = 0;

        for(int i =0; i< array.length/2;i++){
            boolean isSorted = true; //标记是否已经有序
            //从左到右的循环
            for(int j = i; j<rightUnsortBorder;j++){
                if (array[j] > array[j+1]) {
                    int tem = array[j];
                    array[j]=array[j+1];
                    array[j+1] = tem;
                    isSorted=false;
                    lastRightExchangeIndex =j;
                }
            }
            rightUnsortBorder = lastRightExchangeIndex;
            if(isSorted){
                break;
            }
            //从右到左的循环
            isSorted=true;
            for(int j = array.length-i-1;j>leftUnsortBorder;j--){
                if(array[j]<array[j-1]){
                    int tem = array[j];
                    array[j]=array[j-1];
                    array[j-1] = tem;
                    isSorted=false;
                    lastLeftExchangeIndex = j;
                }
            }
            leftUnsortBorder = lastLeftExchangeIndex;
            if(isSorted){
                break;
            }
        }

        System.out.println(Arrays.toString(array));
    }

}
