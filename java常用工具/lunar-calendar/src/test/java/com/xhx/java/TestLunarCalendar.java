package com.xhx.java;

import org.junit.Test;

import java.util.Arrays;

public class TestLunarCalendar {
    @Test
    public void test01(){
        int[] ints = LunarCalendar.solarToLunar(2019, 1, 6);
        System.out.println(Arrays.asList(ints));
    }
}
