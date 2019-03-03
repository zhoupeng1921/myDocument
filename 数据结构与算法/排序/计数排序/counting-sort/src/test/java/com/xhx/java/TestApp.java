package com.xhx.java;


import org.junit.Test;

import java.util.Arrays;

/**
 * 计数排序
 * 试用范围：整数、区间不是太大
 * 时间复杂度：Ο(n+k)（其中k是整数的范围）
 *
 * 基本思想：
 *

 1、找出待排序的数组中最大和最小的元素

 2、统计数组中每个值为i的元素出现的次数，存入数组 C 的第 i 项

 3、对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）

 4、反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1

 *
 */
public class TestApp {

    @Test
    public void test01(){
        int[] array = {9,5,6,2,9};
        int[] result = sort1(array);

        System.out.println(Arrays.toString(result));
    }
    public int[] sort1(int[] array){

        //找出最大值和最小值
        int max = array[0];
        int min = array[0];
        for(int i = 1;i<array.length;i++){
            if(max<array[i]){
                max = array[i];
            }
            if(min>array[i]){
                min = array[i];
            }
        }

        //做了一步优化，min对应的下标是0，而不是min
        int k = max-min+1;
        int[] temArray = new int[k];

        //计数
        for(int i = 0;i<array.length;i++){
            temArray[array[i]-min]++;
        }

        //累加,确定元素排序后的位置，如果一个位置存在多个元素，每取出一个元素后进行-1
        for(int i = 1;i<temArray.length;i++){
            temArray[i]+=temArray[i-1];
        }

        // array[i]-min 获取元素在计数数组中的索引
        //temArray[array[i]-min]-1  为当前元素排序后的位置（因为索引从0开始所以需要减1），
        //temArray[array[i]-min] 的值减1，因为当前位置可能有重复元素，所以索引减了一个1，下次在遇到相同值的元素放到减1后的索引位置
        int[] resultArray = new int[array.length];
        for(int i = array.length-1;i>=0;i--){
            resultArray[--temArray[array[i]-min]] = array[i];
        }

        return resultArray;
    }


}
