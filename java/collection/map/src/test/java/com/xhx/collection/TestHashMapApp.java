package com.xhx.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * xuhaixing
 * 2018/7/15 19:59
 **/
public class TestHashMapApp {


    /**
     * 循环的几种方式
     */
    @Test
    public void testHashMap1(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("a","aaa");
        map.put("b","bbb");
        map.put("c","ccc");
        map.put("d","ddd");

        //通过key    Set<T> key = map.keySet()
        for(String key:map.keySet()){
            System.out.println("key="+key+" value="+map.get(key));
        }

        //key和value都循环
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println("key="+entry.getKey()+" value="+entry.getValue());
        }

        //通过迭代器
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key="+entry.getKey()+" value="+entry.getValue());
        }

        //只循环value
        for(String value : map.values()){
            System.out.println("value="+value);
        }

    }

    public void testHashMapAndHashTable(){
        HashMap<String,Object> map = new HashMap();
        Hashtable<String,Object> hashtable = new Hashtable();
    }
}


