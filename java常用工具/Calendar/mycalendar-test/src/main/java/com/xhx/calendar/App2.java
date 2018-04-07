package com.xhx.calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * @author xuhaixing
 * @date 2018/1/20 12:09
 */
public class App2 {
    /**
     *     取得当天的起始时间
     */
    private static Calendar getDayStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);

        System.out.println("当天开始时间："+calendar.getTime());
        return  calendar;
    }

    /**
     * 获取当天结束时间
     * @return
     */
    public static Calendar getDayEndTime(){
        Calendar calendar = getDayStartTime();

        calendar.add(Calendar.DATE,1);
        calendar.add(Calendar.MILLISECOND,-1);
        System.out.println("当天结束时间: "+calendar.getTime());
        return calendar;
    }

    public static Calendar getFirstDayOfMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);

        System.out.println("当前月第一天: "+calendar.getTime());
        return calendar;
    }

    /**
     * 获得所在月份最后一天
     * @return
     */
    public static Calendar getEndDayOfMonth(){
        //第一种实现方式  月份+1，日期置1，日期-1 （只关注日期，不关注时间）
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH,1);
        calendar1.set(Calendar.DAY_OF_MONTH,1);
        calendar1.add(Calendar.DAY_OF_MONTH,-1);
        System.out.println("所在月份最后一天: "+calendar1.getTime());

        //第二种实现方式  月份+1，日期置1，时间置0，毫秒减一
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.add(Calendar.MONTH,1);
        calendar2.set(Calendar.DAY_OF_MONTH,1);
        calendar2.set(Calendar.HOUR_OF_DAY,0);
        calendar2.set(Calendar.MINUTE,0);
        calendar2.set(Calendar.SECOND,0);
        calendar2.set(Calendar.MILLISECOND,0);
        calendar2.add(Calendar.MILLISECOND,-1);
        System.out.println("所在月份最后一天："+calendar2.getTime());

        
        return calendar1;
    }

    /**
     * 上个月最后一天
     * @return
     */
    public static Calendar getPreMonthOfMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH,0);  //日期设置为0，为上个月最后一天
        System.out.println("上个月最后一天："+calendar.getTime());
        return calendar;
    }

    /**
     * 设置时间
     * @return
     */
    public static Calendar setDateTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,10,16,9,8,7);
        System.out.println("当前时间："+calendar.getTime());
        return calendar;
    }
    public static void main(String[] args) {
        setDateTime();
        getDayStartTime();
        getDayEndTime();
        getFirstDayOfMonth();
        getEndDayOfMonth();
        getPreMonthOfMonth();
    }



}
