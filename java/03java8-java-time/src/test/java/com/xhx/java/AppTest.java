package com.xhx.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testLocalDate() {
        //当前日期
        LocalDate now = LocalDate.now();
        System.out.println(now);

        //当前日期加上时间
        LocalDateTime localDateTime = now.atTime(LocalTime.now());
        System.out.println(localDateTime);

        LocalDate localDate = LocalDate.of(2018, Month.OCTOBER, 1);
        System.out.println(localDate);

        LocalDate localDate2 = LocalDate.of(2018, 10, 1);
        System.out.println(localDate2);

        //转换为当前日期
        LocalDate parse = LocalDate.parse("2018-10-11");
        System.out.println(parse);

        /**
         * 2018-10-08
         * 2018-10-08T11:24:38.603
         * 2018-10-01
         * 2018-10-01
         * 2018-10-11
         */
    }
    @Test
    public void testLocalTime(){
        //当前时间
        LocalTime now  = LocalTime.now();
        System.out.println(now);


        //当前时间加上日期
        LocalDateTime localDateTime = now.atDate(LocalDate.now());
        System.out.println(localDateTime);

        LocalTime of = LocalTime.of(11, 20);
        System.out.println(of);

        //转换时间
        LocalTime parse = LocalTime.parse("11:25");
        System.out.println(parse);
        /**
         * 11:27:01.926
         * 2018-10-08T11:27:01.926
         * 11:20
         * 11:25
         */
    }

    @Test
    public void testLocalDateTime(){
        //当前日期时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        //按时区显示时间
        ZoneId zoneId = ZoneId.of("America/Chicago");
        LocalDateTime now1 = LocalDateTime.now(zoneId);
        System.out.println(now1);

        LocalDateTime of = LocalDateTime.of(2018, 10, 12, 11, 15);
        System.out.println(of);

        //转换日期时间
        LocalDateTime parse = LocalDateTime.parse("2018-10-08T11:19");
        System.out.println(parse);

        LocalDateTime of1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(of1);

        /**
         * 2018-10-08T13:49:10.279
         * 2018-10-08T00:49:10.281
         * 2018-10-12T11:15
         * 2018-10-08T11:19
         * 2018-10-08T13:49:10.296
         */
    }

    @Test
    public void testYear(){
        //当前年
        Year now = Year.now();
        System.out.println(now);

        //当前年加上天转换为日期
        LocalDate localDate = now.atDay(1);
        System.out.println(localDate);

        //年加上月份转换为年月
        YearMonth yearMonth = now.atMonth(2);
        System.out.println(yearMonth);

        Year of = Year.of(2017);
        System.out.println(of);

        Year parse = Year.parse("2019");
        System.out.println(parse);

        //是否是瑞年
        boolean leap = Year.isLeap(2018);
        System.out.println(leap);

        /**
         * 2018
         * 2018-01-01
         * 2018-02
         * 2017
         * 2019
         * false
         */
    }

    @Test
    public void testMonth(){
        Month of = Month.of(10);
        System.out.println(of);
        Month october = Month.OCTOBER;
        System.out.println(october);

        Month plus = of.plus(1);
        System.out.println(plus);

        /**
         * OCTOBER
         * OCTOBER
         * NOVEMBER
         */
    }

    @Test
    public void testDateTimeFormatter(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd");
        String format = dtf.format(LocalDate.now());
        System.out.println(format);

        TemporalAccessor parse = dtf.parse("2018 10 20");
        LocalDate from = LocalDate.from(parse);
        System.out.println(from);
        /**
         * 2018 10 08
         * 2018-10-20
         */
    }

    @Test
    public void testInstant(){
        Instant now = Instant.now();
        System.out.println(now);

        LocalDateTime from = now.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(from);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        System.out.println(localDateTime);

        System.out.println(now.getEpochSecond()); //秒
        System.out.println(now.toEpochMilli()); //毫秒
        /**
         * 2018-10-08T03:46:13.879Z
         * 2018-10-08T11:46:13.879
         * 2018-10-08T11:46:13.879
         * 1538971313
         * 1538971313287
         */
    }

    @Test
    public void testDateToInstant(){
        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println(instant);
        /**
         * 2018-10-08T04:01:16.569Z
         */
    }

    @Test
    public void testInstantToDate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());

        Date date = Date.from(zonedDateTime.toInstant());

        System.out.println(localDateTime);
        System.out.println(date);

        /**
         * 2018-10-08T11:54:36.452
         * Mon Oct 08 11:54:36 CST 2018
         */

    }

    @Test
    public  void testZonedDateTime(){
        ZonedDateTime of = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Shanghai"));
        System.out.println(of);
        //2018-10-08T11:57:12.316+08:00[Asia/Shanghai]
    }

    @Test
    public void testZoneId(){
        //所有可用时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);

        ZoneId of = ZoneId.of("Asia/Shanghai");
        System.out.println(of.getRules());
        //ZoneRules[currentStandardOffset=+08:00]

    }

    /**
     * 获取时间差值
     */
    @Test
    public void testDuration(){
        LocalTime now = LocalTime.now();
        LocalTime of = LocalTime.of(0, 30, 0);
        Duration between = Duration.between(now, of);
        System.out.println(between.toHours());
        System.out.println(between.toMinutes());

        /**
         * -11
         */
    }

    @Test
    public void testChronoUnit(){
        LocalTime now = LocalTime.now();
        LocalTime of = LocalTime.of(0, 30, 0);
        long between = ChronoUnit.HOURS.between(now, of);
        System.out.println(between);
        //-15
    }

    @Test
    public void testTemporalAdjuster(){
        //计算这个月的第一个星期一是哪天
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY);
        LocalDate with = LocalDate.now().with(temporalAdjuster);
        System.out.println(with);

        //计算下一个星期一是哪天
        TemporalAdjuster next = TemporalAdjusters.next(DayOfWeek.MONDAY);
        LocalDate with1 = LocalDate.now().with(next);
        System.out.println(with1);

        /**
         * 2018-10-01
         * 2018-10-15
         */
    }

    @Test
    public void testClock(){
        Clock clock = Clock.systemDefaultZone();
        System.out.println("系统当前时间："+clock.instant());
        System.out.println("毫秒时间："+clock.millis());
        System.out.println(System.currentTimeMillis());

        Clock clock1 = Clock.systemUTC();
        System.out.println(clock1.instant());

        Clock offset = Clock.offset(clock, Duration.ofHours(2));
        System.out.println(offset.instant());

        Clock clock2 = Clock.system(ZoneId.of("Asia/Shanghai"));// 上海时区
        System.out.println(clock2.instant());// 每次调用将返回当前瞬时时间（UTC）
        System.out.println(Date.from(clock2.instant()));


        /**
         * 系统当前时间：2018-10-08T08:28:55.660Z
         * 毫秒时间：1538987335673
         * 1538987335673
         * 2018-10-08T08:28:55.673Z
         * 2018-10-08T10:28:55.673Z
         * 2018-10-08T08:28:55.673Z
         * Mon Oct 08 16:28:55 CST 2018
         */

    }
}
