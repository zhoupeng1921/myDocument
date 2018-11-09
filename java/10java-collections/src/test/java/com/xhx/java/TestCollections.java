package com.xhx.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Collections 是服务于Collection框架的一个工具类
 */
public class TestCollections {
    private List<String> strList;
    {
        strList = new ArrayList<>();
        strList.add("z");
        strList.add("y");
        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("d");
    }

    /**
     * 集合元素反转
     * public static void reverse(List<?> list)
     */
    @Test
    public void test1(){
        Collections.reverse(strList);
        System.out.println(strList);
        //[d, c, b, a, y, z]
    }

    /**
     * 排序
     * 第二个参数可选，排序规则
     */
    @Test
    public void test2(){
        //倒序排列
        Collections.sort(strList,(a,b)->b.compareTo(a));
        System.out.println(strList);
        // [z, y, d, c, b, a]
    }

    /**
     * 查找最大最小元素
     * 第二个参数可选，比较规则
     */
    @Test
    public void test3(){
        String max = Collections.max(strList);
        String min = Collections.min(strList);
        System.out.println(max+"  "+min);
        //z  a
    }

    /**
     * binarySearch 查找集合内是否有某元素，前提是已经有序
     */
    @Test
    public void test4(){
        Collections.sort(strList);
        int c = Collections.binarySearch(strList, "c");
        System.out.println(c);
    }

    /**
     * replaceAll
     * 替换所有
     */
    @Test
    public void test5(){
        strList.add("a");
        Collections.replaceAll(strList,"a","h");
        System.out.println(strList);
        //[z, y, h, b, c, d, h]
    }

    /**
     * swap
     * 交换两元素位置
     */
    @Test
    public void test6(){
        Collections.swap(strList,0,3);
        System.out.println(strList);
        //[b, y, a, z, c, d]
    }

    /**
     * EMPTY_LIST   EMPTY_SET   EMPTY_MAP
     * 返回不可变的空集合
     */
    @Test
    public void test7(){
        List<Object> objects = Collections.EMPTY_LIST;
        //objects.add("afs");
        //objects.set(0,"ad");
        //UnsupportedOperationException
        System.out.println(objects);
        //[]
    }

    /**
     * addAll
     * 为集合添加内容
     */
    @Test
    public void test8(){
        Collections.addAll(strList,"o","w","n");
        System.out.println(strList);
        //[z, y, a, b, c, d, o, w, n]
    }


    /**
     * unmodifiableXXXXX
     * 返回一个不可修改的集合
     * 原理可以看源码，对修改操作抛了异常
     */
    @Test
    public void test9(){
        Collection<String> strings =
                Collections.unmodifiableCollection(strList);
        strings.add("abd");
        System.out.println(strings);
    }

    /**
     * synchronizedXXX
     * 返回一个线程安全的集合
     * 原理是用synchronized对对象加锁
     */
    @Test
    public void test10(){
        List<String> strings = Collections.synchronizedList(strList);

    }

}
