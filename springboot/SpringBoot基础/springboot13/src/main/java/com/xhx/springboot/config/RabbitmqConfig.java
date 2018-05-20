package com.xhx.springboot.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * xuhaixing
 * 2018/5/17 20:23
 */
@Component
public class RabbitmqConfig {

    @Bean
    public Queue queueDefault(){
        return new Queue("DEFAULT_A",true,false,false);
    }

    @Bean
    public Queue queueDirect1(){
        return new Queue("DIRECT_A",true,false,false);
    }


    //topic队列
    @Bean
    public Queue queueTopic1(){
        return new Queue("TOPIC_A",true,false,false);
    }
    @Bean
    public Queue queueTopic2(){
        return new Queue("TOPIC_B",true,false,false);
    }

    //fanout队列
    @Bean
    public Queue queueFanout1(){
        return new Queue("FANOUT_A",true,false,false);
    }
    @Bean
    public Queue queueFanout2(){
        return new Queue("FANOUT_B",true,false,false);
    }



    @Bean
    public DirectExchange getDirectExchange(){
        return new DirectExchange("DIRECT_EXCHANGE",true,false);
    }
    @Bean
    public FanoutExchange getFanoutExchange(){
        return new FanoutExchange("FANOUT_EXCHANGE",true,false);
    }
    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange("TOPIC_EXCHANGE",true,false);
    }

    /**
     * 模糊匹配
     * @param queueTopic1
     * @param exchange
     * @return
     */
    @Bean
    public Binding getBindingTopic1(Queue queueTopic1,TopicExchange exchange){
        return BindingBuilder.bind(queueTopic1).to(exchange).with("TOPIC.#");
    }
    /**
     * 精确匹配
     * @param queueTopic2
     * @param exchange
     * @return
     */
    @Bean
    public Binding getBindingTopic2(Queue queueTopic2,TopicExchange exchange){
        return BindingBuilder.bind(queueTopic2).to(exchange).with("TOPIC.B");
    }

    @Bean
    public Binding getBindingFonout1(Queue queueFanout1,FanoutExchange FanoutExchange){
        return  BindingBuilder.bind(queueFanout1).to(FanoutExchange);
    }
    @Bean
    public Binding getBindingFonout2(Queue queueFanout2,FanoutExchange FanoutExchange){
        return  BindingBuilder.bind(queueFanout2).to(FanoutExchange);
    }

    @Bean
    public Binding getBindingDirect(Queue queueDirect1,DirectExchange directExchange){
        return  BindingBuilder.bind(queueDirect1).to(directExchange).with("DIRECT_QUEUE");
    }


}
