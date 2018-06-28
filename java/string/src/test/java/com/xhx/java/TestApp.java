package com.xhx.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * xuhaixing
 * 2018/6/27 9:43
 */

public class TestApp {


    @Test
    public void testEquals(){
        String a1 = "aaaa";
        String a2 = "aaaa";
        System.out.println(a1==a2);
        /**
         * true
         */
    }

    @Test
    public void testBytes() throws Exception{
//        FileInputStream fileInputStream = new FileInputStream("E:\\myDocuments\\java\\string\\aa.txt");
//        byte[] gb2312s = new byte[1024];
//        int read = fileInputStream.read(gb2312s);
//        String s = new String(gb2312s,0,read,"gb2312");
        String str  = "嘻嘻哈哈";
        byte[] gb2312s = str.getBytes("GB2312");
        String s = new String(gb2312s,"GB2312");
        System.out.println(s);

        FileOutputStream fileOutputStream = new FileOutputStream("bb.txt");
        fileOutputStream.write(s.getBytes("GB2312"));
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
