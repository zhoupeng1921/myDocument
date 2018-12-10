package springboot.config;

import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import springboot.mq.QueueConsumer;
import springboot.mq.TopicConsumer;

@Configuration
public class JmsConfig {

    @Autowired
    private PooledConnectionFactory connectionFactory;

    @Autowired
    private TopicConsumer topicConsumer;

    @Autowired
    private QueueConsumer queueConsumer;

    /**
     * @return
     */

    @Bean(value = "topicJmsContainer")
    public DefaultMessageListenerContainer topicJmsContainer(){
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setPubSubDomain(true);
        container.setDestinationName("Q_TOPIC_USERIDENTITY");
        container.setMessageListener(topicConsumer);
        container.setSessionAcknowledgeMode(1);
        return container;
    }
    @Bean(value = "queueJmsContainer")
    public DefaultMessageListenerContainer queueJmsContainer(){
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setPubSubDomain(false);
        container.setDestinationName("Q_QUEUE_USERIDENTITY");
        container.setMessageListener(queueConsumer);
        container.setSessionAcknowledgeMode(1);
        return container;
    }
}
