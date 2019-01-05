package com.xhx.mqtest.pointtopoint;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 多个消费者时，设置消息独占 ?consumer.exclusive=true
 */
public class JMSConsumer3 {
    private static final String USERNAME= ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORK= ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKERURL="tcp://192.168.94.151:61616";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection=null;
        Session session = null;
        Destination destination;
        MessageConsumer messageConsumer;

        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer3.USERNAME, JMSConsumer3.PASSWORK, JMSConsumer3.BROKERURL);

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("Q-NUMBER?consumer.exclusive=true");
            messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(new JMSListener());
            //会一直监听,连接不能关闭

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
