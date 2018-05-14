package com.xhx.rabbitmq.receive;

import com.rabbitmq.client.*;
import com.xhx.rabbitmq.connect.BaseConnect;
import com.xhx.rabbitmq.entity.MessageInfo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * xuhaixing
 * 2018/5/14 16:38
 */
public class ReceiverHandler extends BaseConnect implements Runnable, Consumer {

    private int hashCode = 0;

    public ReceiverHandler(String queueName) throws Exception {
        super(queueName);
    }


    public void receiveMessage() {
        hashCode = Thread.currentThread().hashCode(); //区分不同工作进程的输出
        try {
            String queue = channel.queueDeclare(queueName+1, false, false, false, null).getQueue();
            String queue2 = channel.queueDeclare(queueName+2, false, false, false, null).getQueue();
            channel.queueBind(queue,BaseConnect.EXCHANGE_NAME,"");
            channel.queueBind(queue2,BaseConnect.EXCHANGE_NAME,"");
            System.out.println(hashCode + "，等待消息中...");


            // defaultConsumer实现了Consumer，我们将使用它来缓存生产者发送过来储存在队列中的消息。当我们可以接收消息的时候，从中获取，可理解为被一个一直运行着的线程调用。
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    Object obj = toObject(body);
                    System.out.println("channel:"+channel+",queue:"+queue+",consumer:"+this.getConsumerTag()+"  Received '" + obj + "'");
//                channel.basicAck(envelope.getDeliveryTag(),false);
                    try {
                        Thread.sleep(300);
                    } catch (Exception e) {
                    }
                }
            };
            String result = channel.basicConsume(queue, true, consumer);
            String result2 = channel.basicConsume(queue2, true, consumer);
          //  String result = channel.basicConsume(queueName, true, this);
            System.out.println("--------result:" + result);
            System.out.println("--------result:" + result2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void handleConsumeOk(String consumerTag) {

    }

    @Override
    public void handleCancelOk(String consumerTag) {

    }

    @Override
    public void handleCancel(String consumerTag) throws IOException {

    }

    @Override
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {

    }

    @Override
    public void handleRecoverOk(String consumerTag) {

    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        MessageInfo messageInfo = (MessageInfo) toObject(body);
        messageInfo.setHashCode(hashCode);
        System.out.println("messageInfo======:" + messageInfo.toString());
    }

    @Override
    public void run() {
        receiveMessage();
    }


    public Object toObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }
}
