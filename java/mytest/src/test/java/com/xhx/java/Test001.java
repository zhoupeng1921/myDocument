package com.xhx.java;

import org.junit.Test;

/**
 * xuhaixing
 * 2018/6/21 10:41
 **/
public class Test001 {
    static{
        i = 0;//给变量赋值可以正常编译通过
        //System.out.print(i);//这句编译器会提示"非法向前引用"
    }
    static int i=1;


    @Test
    public void test01(){
        System.out.println(i);
    }

    @Test
    public void test02(){
        short s1 = 1;
        s1+=1;

    }

    @Test
    public void test03(){
        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;
        //false 两个引用没有引用同一对象
        System.out.println(a == b);
        //true a自动拆箱成int类型再和c比较
        System.out.println(a == c);

    }

    @Test
    public void test04(){
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        //true
        System.out.println(f1 == f2);
        //false
        System.out.println(f3 == f4);

    }

    @Test
    public void test05(){
        System.out.println(Math.round(-11.5));
        System.out.println(Math.round(-11.4));
        System.out.println(Math.round(-11.6));
        /**
         * -11
         * -11
         * -12
         */
    }

    @Test
    public void test06() throws Exception{
        String str = new String("你好".getBytes("GB2312"), "ISO-8859-1");
        System.out.println(str);
    }
}
