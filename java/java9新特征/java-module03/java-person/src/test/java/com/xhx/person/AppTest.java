package com.xhx.person;

import org.junit.Test;

import java.util.Arrays;

public class AppTest {

    @Test
    public void test1() throws Exception{
        Class<?> house = Class.forName("com.xhx.house.House");
        Arrays.stream(house.getDeclaredMethods()).forEach(method -> {
            System.out.println(method.getName());
        });
    }
}
