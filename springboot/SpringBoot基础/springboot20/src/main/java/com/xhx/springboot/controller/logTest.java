package com.xhx.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * xuhaixing
 * 2018/5/25 13:43
 */
@Component
public class logTest {
    private Logger logger = LoggerFactory.getLogger(logTest.class);

    @Scheduled(fixedRate = 10000)
    public void logtest(){

        logger.trace("日志trace");
        logger.debug("日志debug");
        logger.info("日志info");
        logger.warn("日志warn");
        logger.error("日志error");
    }
}
