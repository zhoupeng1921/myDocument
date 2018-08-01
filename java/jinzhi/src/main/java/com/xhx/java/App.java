package com.xhx.java;/*
 * Administrator
 * 2018/8/1  10:37
 *
 */

public class App {
    public static void main(String[] args) {
        int businessType = 3;
        String str ;
        StringBuilder binary=new StringBuilder();
        if(businessType==0){
            str =  "000";
        }
        while(businessType!=0){
            int bit=businessType&1;
            binary=binary.append(bit);
            businessType=businessType>>1;
        }
        binary.reverse();
        int tem  = 3-binary.length();
        str = binary.insert(0, new char[]{'0', '0', '0'}, 0, tem).toString();
        System.out.println(str);
    }
}
