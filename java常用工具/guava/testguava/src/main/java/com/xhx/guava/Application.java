package com.xhx.guava;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/1/21 12:01
 */
public class Application {
    //用户检查参数,false,抛异常
    public static void testCheckArgument(int num) {
        Preconditions.checkArgument(num > 0, "num必须大于等于0");
    }

    //用户检查是否为空,null, 抛异常
    public static void testCheckNotNull(String str) {
        Preconditions.checkNotNull(str,"不能为空");
    }

    //用于检查对象状态  false 抛异常
    public static void testCheckState(List list, int num){
        Preconditions.checkState(list.size()<num,"长度不能大于"+num);
    }

    //检查index 是否在[0,size)中
    public static void testCheckElementIndex(int index, int size){
        Preconditions.checkElementIndex(index,size,"index="+index+",不在size="+size+"中");
    }

    //检查index 是否在[0,size]中
    public static void testcheckPositionIndex(int index, int size){
        Preconditions.checkPositionIndex(index,size,"index="+index+",不在size="+size+"中");
    }

    //检查[start,end]是否在size中
    public static void testCheckPositionIndexes(int start, int end, int size){
        Preconditions.checkPositionIndexes(start,end,size);
    }
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("aa");

        arrayList.add("bb");
        arrayList.add("cc");

        testCheckArgument(-1);

        testCheckNotNull(null);

        testCheckState(arrayList,2);

        testCheckElementIndex(3,arrayList.size());

        testcheckPositionIndex(3,arrayList.size());

        testCheckPositionIndexes(0,3,arrayList.size());

    }
}
