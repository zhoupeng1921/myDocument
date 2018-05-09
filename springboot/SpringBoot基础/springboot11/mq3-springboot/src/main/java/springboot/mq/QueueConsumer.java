package springboot.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class QueueConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            try {
                System.out.println("收到的QUEUE消息:"+((TextMessage) message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
