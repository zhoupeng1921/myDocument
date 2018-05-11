package com.xhx.springboot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * xuhaixing
 * 2018/5/11 16:17
 */
@Configuration
public class RabbitmqConfig {

    /**
     * 创建一个队列
     * @return
     */
    @Bean
    public Queue Queue(){
        return new Queue("Q_QUEUE");
    }
}
