package com.xhx.mqtest.pointtopoint;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Objects;

/**
 * p2p
 * 当多个消费者存在时，每个消息也只能被一个消费者消费
 */
public class JMSProducer {
    private static final String USERNAME = "admin"; //ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = "admin"; // ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKERURL = "tcp://192.168.94.151:61616";
    //private static final String BROKERURL= ActiveMQConnection.DEFAULT_BROKER_URL;


    public static void main(String[] args) {
        System.out.println(BROKERURL);

        Connection connection = null;
        Session session = null;
        Destination destination;
        MessageProducer messageProducer;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKERURL);

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("Q-NUMBER");
            messageProducer = session.createProducer(destination);
            for (int i = 0; i < 2; i++) {
                try {
                    TextMessage textMessage = session.createTextMessage("ActiveMQ发送消息"+i);
                    System.out.println(textMessage.getText());
                    //设置过期时间，ms。默认消息永不过期
                    messageProducer.setTimeToLive(24 * 60 * 60 * 1000);
                    //设置是持久还是非持久消息,持久化后，若消费未被消费，mq服务器重启，消息不会丢失
                    messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
                    //设置优先级
                    messageProducer.setPriority(4);
                    messageProducer.send(textMessage);
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
//            提交
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                session.rollback();
            } catch (JMSException e1) {
                e1.printStackTrace();
            }
        } finally {
            if (Objects.nonNull(session)) {
                try {
                    session.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(connection)) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
