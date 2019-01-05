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

    /**
     * fill
     * 替换所有元素
     */
    @Test
    public void test11(){
        Collections.fill(strList,"abcd");
        System.out.println(strList);
        //[abcd, abcd, abcd, abcd, abcd, abcd]
    }

    /**
     * copy
     * 将一个集合中的元素复制到另一个集合，会覆盖内容，剩余的元素不受影响
     */
    @Test
    public void test12(){
        List<String> strList2 = new ArrayList<>();
        strList2.add("eee");
        strList2.add("bbb");
        //将strList2 复制到 strList中
        Collections.copy(strList,strList2);
        System.out.println(strList);
        //[eee, bbb, a, b, c, d]
    }




    /**
     * indexOfSubList
     *  目标列表第一次在源列表出现的位置
     */
    @Test
    public  void test13(){
        List<String> strList2 = new ArrayList<>();
        strList2.add("a");
        strList2.add("b");
        int i = Collections.indexOfSubList(strList, strList2);
        System.out.println(strList);
        System.out.println(strList2);
        System.out.println(i);
        //2
    }

    /**
     * lastIndexOfSubList
     * 查找目标列表最后一次在源列表中出现的位置
     */
    @Test
    public  void test14(){
        List<String> strList2 = new ArrayList<>();
        strList2.add("a");
        strList2.add("b");
        strList.addAll(strList2);
        int i = Collections.lastIndexOfSubList(strList, strList2);
        System.out.println(strList);
        System.out.println(strList2);
        System.out.println(i);
        // [z, y, a, b, c, d, a, b]
        //[a, b]
        // 6
    }

    /**
     * rotate
     * 根据指定的距离，循环移动列表中元素
     */
    @Test
    public void test15(){
        System.out.println(strList);
        Collections.rotate(strList,-1);
        System.out.println(strList);
        //[z, y, a, b, c, d]
        //[y, a, b, c, d, z]
    }

    /**
     * frequency
     * 查询指定元素在集合中出现的次数
     */
    @Test
    public void test16(){
        strList.add("a");
        int count = Collections.frequency(strList, "a");
        System.out.println(count);
        //2
    }

    /**
     * nCopies
     * 把对象复制多份
     */
    @Test
    public void test17(){
        List<List<String>> lists = Collections.nCopies(3, strList);
        System.out.println(lists);
        //[[z, y, a, b, c, d], [z, y, a, b, c, d], [z, y, a, b, c, d]]
    }

    /**
     * shuffle
     * 混排 打乱顺序
     */
    @Test
    public void test18(){
        Collections.shuffle(strList);
        System.out.println(strList);
    }

    /**
     * singletonList
     * 返回一个只包含指定对象的不可变列表
     */
    @Test
    public void test19(){
        List<String> siList = Collections.singletonList("哈哈");
        System.out.println(siList);
        //[哈哈]
    }

    /**
     * checkedXXXX
     * 返回检查容器，对传入的对象会进行类型检查
     */
    @Test
    public void test20(){
        List list1 = strList;
        list1.add(123);  //这里会执行成功
        System.out.println("success");
        List strings = Collections.checkedList(strList, String.class);
        strings.add(123); //这里会执行失败

    }

}
