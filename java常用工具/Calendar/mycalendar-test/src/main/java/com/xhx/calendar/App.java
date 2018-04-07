package com.xhx.calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * @author xuhaixing
 * @date 2018/1/20 12:09
 */
public class App {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Date time = calendar.getTime();
        System.out.println("当前时间:"+time.toString());

        int year = calendar.get(Calendar.YEAR);
        System.out.println("当前年份:"+year);

        /**
         * 月份从0开始，需要加1
         */
        int month = calendar.get(Calendar.MONTH);
        System.out.println("当前月份:"+(month+1));

        int day = calendar.get(Calendar.DATE);
        System.out.println("当前日:"+day);

        /**
         * 周日是第一天
         */
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("本周第几天:"+dayOfWeek);

        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);  //和DATE一样的
        System.out.println("本月第几天:"+dayOfMonth);

        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println("今年的第几天:"+dayOfYear);

        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println("当前小时数:"+hourOfDay);

        int hour = calendar.get(Calendar.HOUR);
        System.out.println("----------"+hour);

        int minute = calendar.get(Calendar.MINUTE);
        System.out.println("当前分钟数:"+minute);

        int second = calendar.get(Calendar.SECOND);
        System.out.println("当前秒数:"+second);

        calendar.add(Calendar.MINUTE,20);
        int minuteAddTime = calendar.get(Calendar.MINUTE);
        System.out.println("增加20分钟:"+minuteAddTime);

        calendar.add(Calendar.MINUTE,-30);
        int minuteMiTime = calendar.get(calendar.MINUTE);
        System.out.println("减20分钟:"+minuteMiTime);

        Calendar newCalendar = Calendar.getInstance();
        int i = calendar.compareTo(newCalendar);
        System.out.println("小于:"+i); //小-1  等于0  大于 1

        int n = newCalendar.compareTo(calendar);
        System.out.println("大于:"+n);

        int m = newCalendar.compareTo(newCalendar);
        System.out.println("等于:"+m);


        /**
         * 计算时间差
         */
        long timeDiff = newCalendar.getTimeInMillis() - calendar.getTimeInMillis();
        System.out.println(timeDiff/1000/60);

    }

}
