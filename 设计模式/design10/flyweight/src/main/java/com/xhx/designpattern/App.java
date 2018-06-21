package com.xhx.designpattern;

/**
 * xuhaixing
 * 2018/6/19 22:35
 **/
public class App {
    public static void main(String[] args) {
        String s1 = "aaa";
        String s2="aaa";
        System.out.println(s1==s2);

        String s3 = new String("aaa");
        String s4="aaa";
        System.out.println(s3==s4);
    }
}
