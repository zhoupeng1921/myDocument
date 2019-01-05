package springboot.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 不推荐一个bean走天下，不管是connection还是jmsTemplate，建议根据业务
 * 场景设置不同的参数
 *
 * 自定义jmsTemplate
 */
@Configuration
public class MQconfig {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean(name = "myQueue")
    public Queue myQueue(){
        return new ActiveMQQueue("my.queue");
    }
    @Bean(name = "myTopic")
    public Topic myTopic(){
        return new ActiveMQTopic("my.topic");
    }

    @Bean(name = "jmsQueueTemplate")
    @Primary
    public JmsTemplate jmsQueueTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setPubSubDomain(false);
        //为true时，deliveryMode, priority, timeToLive才有效
        jmsTemplate.setExplicitQosEnabled(true);
        jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
        //开启事物支持
        jmsTemplate.setSessionTransacted(true);
        return jmsTemplate;
    }
    @Bean(name = "jmsTopicTemplate")
    @Primary
    public JmsTemplate jmsTopicTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.setExplicitQosEnabled(true);
        jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
        jmsTemplate.setSessionTransacted(true);
        return jmsTemplate;
    }

    @Bean(name = "jmsQueueMessagingTmeplate")
    public JmsMessagingTemplate jmsQueueMessagingTmeplate(@Qualifier("jmsQueueTemplate") JmsTemplate jmsQueueTemplate){
        return new JmsMessagingTemplate(jmsQueueTemplate);
    }
    @Bean(name = "jmsTopicMessagingTmeplate")
    public JmsMessagingTemplate jmsTopicMessagingTmeplate(@Qualifier("jmsTopicTemplate") JmsTemplate jmsTopicTemplate){
        return new JmsMessagingTemplate(jmsTopicTemplate);
    }
}
