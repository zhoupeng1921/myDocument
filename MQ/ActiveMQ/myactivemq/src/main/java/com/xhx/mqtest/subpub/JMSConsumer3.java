package com.xhx.mqtest.subpub;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 创建持久订阅者，离线后，重新连接，会收到落下的消息
 */
public class JMSConsumer3 {
    private static final String USERNAME= ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORK= ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKERURL="tcp://192.168.94.151:61616";
    private static final int SENTNUM=10;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection=null;
        Session session = null;
        Topic topic;
        MessageConsumer messageConsumer;

        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer3.USERNAME, JMSConsumer3.PASSWORK, JMSConsumer3.BROKERURL);

        try {
            connection = connectionFactory.createConnection();
            String clientId = "8fc38c5d-a4a9-43bb-b617-03f25cce2da5";
            connection.setClientID(clientId);
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            topic = session.createTopic("myFirstTopic");
            TopicSubscriber durableSubscriber = session.createDurableSubscriber(topic, "sub-durable-"+clientId);
            durableSubscriber.setMessageListener(new JMSListener());


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
