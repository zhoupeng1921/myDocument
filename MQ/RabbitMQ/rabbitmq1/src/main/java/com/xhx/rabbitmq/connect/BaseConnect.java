package com.xhx.rabbitmq.connect;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * xuhaixing
 * 2018/5/14 15:15
 */
public class BaseConnect {
    protected Channel channel;
    protected Connection connection;
    protected String queueName;

    public final static String EXCHANGE_NAME="Q_MESSAGE";

    public BaseConnect(String queueName)throws Exception{
        this.queueName=queueName;
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.94.151");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connection = connectionFactory.newConnection(); //创建连接
        channel = connection.createChannel(); //创建频道
        channel.exchangeDeclare(EXCHANGE_NAME,BuiltinExchangeType.FANOUT);
        channel.queueDeclare(queueName,false,false,false,null);

    }

    protected void close() throws Exception{
        channel.close();
        connection.close();
    }
}
