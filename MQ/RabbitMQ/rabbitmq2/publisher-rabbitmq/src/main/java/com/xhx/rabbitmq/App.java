package com.xhx.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception{
        String queueName = "Q_QUEUE_NAME";
        String message = "Hello world";

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.94.151");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(queueName,false,false,false,null);
        channel.basicPublish("",queueName,null,message.getBytes());

        channel.close();
        connection.close();



    }
}
