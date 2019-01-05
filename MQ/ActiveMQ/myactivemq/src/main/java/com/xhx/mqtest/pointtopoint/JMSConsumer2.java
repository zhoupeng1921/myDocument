package com.xhx.mqtest.pointtopoint;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 非阻塞式接收消息=监听  连接不能关，关了就不监听了
 * ?consumer.prefetchSize=10  预取消息数（不是指同时处理的数量）
 */
public class JMSConsumer2 {
    private static final String USERNAME= ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORK= ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKERURL="tcp://192.168.94.151:61616";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection=null;
        Session session = null;
        Destination destination;
        MessageConsumer messageConsumer;

        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer2.USERNAME, JMSConsumer2.PASSWORK, JMSConsumer2.BROKERURL);

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("Q-NUMBER?consumer.prefetchSize=10");
            messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(new JMSListener());

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            //连接不能关，关了就不监听了
        }
    }
}
