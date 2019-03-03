package com.xhx.java;

import org.junit.Test;

import java.util.Arrays;

/**
 * 将数组分割为若干个子序列，子序列是有固定增量间隔的，不是直接分块
 * 各个子序列进行插入排序
 * 选择更小的增量，再分成若干个子序列，进行插入排序
 * ...
 * 直至增量为1，对整个序列再进行调整
 *
 * 例如：5 3 2 4 9 8 6 ,七个元素，
 * 假设：
 *  开始length/2为增量 3
 *  分成三组 {5,4,6}{3,9}{2,8}进行插入排序:排序后只4与5做了交换
 *  排序后如下：4 3 2 5 9 8 6
 *  然后：length/4为增量 1
 *  {4 3 2 5 9 8 6} 对整个数组进行插入排序
 *
 */
public class TestApp {

    @Test
    public void test01(){
        int[] array = {5, 3, 2, 4, 9, 8, 6};
        sort1(array);
        System.out.println(Arrays.toString(array));
    }

    public int[] sort1(int[] array){
        //开始设置增量间距为array.length/2
        for(int gap = array.length/2;gap>0;gap/=2){
            for(int i = gap;i<array.length;i++){
                int j = i;
                //插入排序
                int tem = array[j];
                while (j-gap>=0&&tem<array[j-gap]){
                    array[j] = array[j-gap];
                    j-=gap;
                }
                array[j] = tem;
            }
        }

        return array;
    }
}
