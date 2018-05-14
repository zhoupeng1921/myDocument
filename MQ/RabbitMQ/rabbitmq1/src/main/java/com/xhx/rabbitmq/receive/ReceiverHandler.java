package com.xhx.rabbitmq.receive;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
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

    private int hashCode=0;

    public ReceiverHandler(String queueName) throws Exception {
        super(queueName);
    }


    public void receiveMessage(){
        hashCode = Thread.currentThread().hashCode(); //区分不同工作进程的输出

        try {
            System.out.println(hashCode+"，等待消息中...");
            String result = channel.basicConsume(queueName, true, this);
            System.out.println("--------result:"+result);

        } catch (IOException e) {
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
        System.out.println("messageInfo======:"+messageInfo.toString());
    }

    @Override
    public void run() {
        receiveMessage();
    }


    public Object toObject (byte[] bytes) {
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
