package com.xhx.java;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;

public class MyTest {

    @Test
    public void testDateTimeFormatter(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ss", Locale.ENGLISH);
       // dtf = new DateTimeFormatterBuilder().parseCaseInsensitive().append(dtf).toFormatter();

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ss", Locale.CHINA);
        String format = dtf.format(LocalDateTime.now());
        String format2 = dtf2.format(LocalDateTime.now());
        System.out.println(format);
        System.out.println(format2);

        TemporalAccessor parse = dtf.parse("2018 10 20 17:03:32");
        TemporalAccessor parse2 = dtf2.parse("2018 10 20 17:03:32");
        LocalDateTime from = LocalDateTime.from(parse);
        LocalDateTime from2 = LocalDateTime.from(parse2);
        System.out.println(from);
        System.out.println(from2);

        LocalDateTime parse1 = dtf.parse("2018 10 20 17:03:32", LocalDateTime::from);
        System.out.println(parse1);
        /**
         * 2018 10 08 17:34:52
         * 2018 10 08 17:34:52
         * 2018-10-20T17:03:32
         * 2018-10-20T17:03:32
         * 2018-10-20T17:03:32
         */
    }

    @Test
    public void testDate(){
        LocalDateTime dateTime = LocalDateTime.now();
        Date from = Date.from(dateTime.atOffset(ZoneOffset.ofHours(8)).toInstant());
        Date from1 = Date.from(dateTime.toInstant(ZoneOffset.ofHours(6)));
        System.out.println(from);
        System.out.println(from1);
        /**
         * Mon Oct 08 17:44:38 CST 2018
         * Mon Oct 08 19:44:38 CST 2018
         */
    }
}
