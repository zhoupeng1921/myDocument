package com.xhx.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class PattrenDemo {
    public static void main(String[] args) {

    }

    /**
     * group()/group(int group)/groupCount()
     */
    @Test
    public void testGroup() {
        Pattern pattern = Pattern.compile("(ca)(t)|(m)");
        String str = "one cat, two cats in the catsYard m";
        Matcher matcher = pattern.matcher(str);

        //代表pattern里面组的数量
        System.out.println("该次查找获得匹配组的总数量" + matcher.groupCount());

        while (matcher.find()) {
            //group(0)是全部
            System.out.println(matcher.group(0)+"---" + matcher.group(1) + "---" + matcher.group(2)+"-----"+matcher.group(3));
        }

        /**
         该次查找获得匹配组的总数量3
         cat---ca---t-----null
         cat---ca---t-----null
         cat---ca---t-----null
         m---null---null-----m
         */
    }

    /**
     * appendReplacement(StringBuffer sb, String replacement)
     * 将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到
     * 上次匹配子串之后的字符串段添加到一个StringBuffer对象里，
     * 而appendTail(StringBuffer sb) 方法则将最后一次匹配工作后剩余的
     * 字符串添加到一个StringBuffer对象里。
     */
    @Test
    public void testAppend() {
        Pattern pattern = Pattern.compile("[a-zA-Z]*");
        String str = "1b 1b 1b 1c 1cn d d d.";
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (matcher.find()) {
            i++;
            //System.out.println(matcher.group());
            matcher.appendReplacement(sb, "2");
            System.out.println("第" + i + "次匹配后的内容是：" + sb.toString());
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
        /**
         *
         Kelvin
         Li
         and
         Kelvin
         Chan
         are
         both
         working
         a1aa a1aa a1aa a1aa a1aa aa aa aa.a
         */
    }


    /**
     * lookingAt ()方法将检测目标字符串是否以匹配的子串起始。
     */
    @Test
    public void testLookAt() {
        String str = "566fasdufshkasd";
        Pattern pattern = Pattern.compile("[5|6]");
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.lookingAt();
        System.out.println(b);

    }

    /**
     * boolean matches()
     * 尝试对整个目标字符展开匹配检测，也就是只有整个目标字符串完全匹配时才返回真值。
     */
    @Test
    public void testMatch() {
        String sap = "12453";
        //Pattern pattern = Pattern.compile("^\\d{1,8}$");
        Pattern pattern = Pattern.compile("^\\d{1,8}$");
        Matcher matcher = pattern.matcher(sap);
        if (matcher.matches()) {
            System.out.println("匹配了");
        } else {
            System.out.println("没匹配");
        }
        String string = matcher.group();
        System.out.println(string);


        /**
         * 匹配了
         */
    }

    /**
     * split 按照正则分割
     */
    @Test
    public void testPattrenSplit() {
        String str = "kevin has see/卡文已经//看过///这本书了";
        Pattern pattern = Pattern.compile("/+");
        String[] result = pattern.split(str);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        System.out.println("===============");
        String[] result2 = pattern.split(str, 2);
        for (int i = 0; i < result2.length; i++) {
            System.out.println(result[i]);
        }
        /*
            kevin has see
            卡文已经
            看过
            这本书了
            ===============
            kevin has see
            卡文已经
         */
    }
}
