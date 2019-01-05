package com.xhx.java;

import org.junit.Test;

import java.io.Serializable;
import java.util.Map;

import static java.util.Map.entry;

public class MapTest {

    /**
     * Map.of(...)创建任意参数的不可变集合
     */
    @Test
    public void test1() {
        Map<String, ? extends Serializable> map1 = Map.of("name", "小红", "age", 24);
        System.out.println(map1);
    }

    /**
     * 可以用Map.entry包装键值对
     */
    @Test
    public void test2() {
        Map<String, String> map2 =
                Map.ofEntries(entry("name", "小红"),
                        entry("age", "24"));
        map2.forEach((k, v) ->
                System.out.printf("key = %s, value = %s  ", k, v));
    }
}
