package com.xhx.springboot.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * xuhaixing
 * 2018/5/6 18:34
 */

@Component
public class Receiver {
    private static Logger logger = LoggerFactory.getLogger(Receiver.class);

    public void receiveMessage(String message) {
        logger.info("收到的mq消息" + message);
    }
}
