package springboot.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Provider {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    @Scheduled(fixedDelay = 5000)//每5秒执行一次
    public void sendTopic() {
        String identityCard = "t188927196512021354";
        ActiveMQTopic destination = new ActiveMQTopic("Q_TOPIC_USERIDENTITY");
        jmsMessagingTemplate.convertAndSend(destination, identityCard);
    }

    @Scheduled(fixedDelay = 5000)
    public void sendQueue() {
        String identityCard = "q188927196512021354";
        ActiveMQQueue destination = new ActiveMQQueue("Q_QUEUE_USERIDENTITY");
        jmsMessagingTemplate.convertAndSend(destination, identityCard);

    }
}
