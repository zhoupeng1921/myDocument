package com.xhx.mqtest.pointtopoint;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 客户端确认，（有一个问题，如果消费了多个消息，只对一个消息进行了确认，其它消息也会被确认）
 */
public class JMSConsumer6 {
    private static final String USERNAME= ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORK= ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKERURL="tcp://192.168.94.151:61616";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection=null;
        Session session = null;
        Destination destination;
        MessageConsumer messageConsumer;

        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer6.USERNAME, JMSConsumer6.PASSWORK, JMSConsumer6.BROKERURL);

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            //打开事物
            session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
            destination = session.createQueue("Q-NUMBER");
            messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(message -> {
                try {
                    System.out.println("收到消息"+((TextMessage)message).getText());
                    //确认消息
                    message.acknowledge();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //连接不能关，关了就不监听了
        }
    }
}
