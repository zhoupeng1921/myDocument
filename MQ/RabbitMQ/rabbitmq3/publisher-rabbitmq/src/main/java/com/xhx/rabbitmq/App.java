package com.xhx.rabbitmq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Random;

/**
 * rabbitmq转发器类型DIRECT    只要routing key与 binding key匹配上就能获得消息
 *
 */
public class App 
{
    private static final String EXCHANGE_NAME="EX_DIRECT";
    private static final String[] ROUTING_KEY= {"A","B","C"};

    public static void main( String[] args ) throws Exception
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setHost("192.168.94.151");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //声明exchange类型
        channel.exchangeDeclare(EXCHANGE_NAME,BuiltinExchangeType.DIRECT);
        for(int i = 0;i<5;i++){
            String routingkey = getRoutingkey();
            System.out.println("routingkey:"+routingkey);
            String message = "我叫xuhaixing";
            //发送消息至转发器，指定routingkey
            channel.basicPublish(EXCHANGE_NAME,routingkey,null,message.getBytes());
        }
        channel.close();
        connection.close();
    }

    /**
     * 随机产生一个routing key,测试DIRECT用
     * @return
     */
    private static String getRoutingkey(){
        Random random = new Random();
        int i = random.nextInt(3);
        return ROUTING_KEY[i];
    }
}
