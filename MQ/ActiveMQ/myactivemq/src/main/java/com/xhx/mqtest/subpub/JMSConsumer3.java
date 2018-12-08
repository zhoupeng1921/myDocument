package com.xhx.mqtest.subpub;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 非阻塞式接收消息
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
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            topic = session.createTopic("myFirstTopic");
            TopicSubscriber durableSubscriber = session.createDurableSubscriber(topic, "sub-name");
            durableSubscriber.setMessageListener(new JMSListener());


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
