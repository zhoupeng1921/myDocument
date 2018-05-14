package com.xhx.rabbitmq.publish;

import com.sun.xml.internal.ws.developer.Serialization;
import com.xhx.rabbitmq.connect.BaseConnect;
import com.xhx.rabbitmq.entity.MessageInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * xuhaixing
 * 2018/5/14 15:58
 */
public class PublisherHandler extends BaseConnect {
    public PublisherHandler(String queueName) throws Exception {
        super(queueName);
    }

    public void sendMessage(MessageInfo messageInfo){
        try {
            channel.basicPublish(BaseConnect.EXCHANGE_NAME,queueName,null,toByteArray(messageInfo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] toByteArray (Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray ();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }
}
