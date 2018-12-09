package springboot.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class Consumer {

    /**
     * 无法收topic，只能收queue，默认spring.jms.pub-sub-domain=false，
     * 若改成true只能接收topic，不能接收queue，所以不能改
     * @param message
     */
    @JmsListener(destination = "Q_TOPIC_USERIDENTITY")
    public void receiveTopic(TextMessage message, Session session) throws JMSException{
        try {
            System.out.println("收到的TOPIC消息:"+message.getText());
            System.out.println(session.getAcknowledgeMode());
        } catch (JMSException e) {
            e.printStackTrace();
            session.recover();
        }
    }

    /**
     * @param message
     */
    @JmsListener(destination = "Q_QUEUE_USERIDENTITY")
    public void receiveQueue(TextMessage message, Session session) throws JMSException{
        try {
            System.out.println("收到的QUEUE消息:"+message.getText());
            System.out.println(session.getAcknowledgeMode());
        } catch (JMSException e) {
            e.printStackTrace();
            session.recover();
        }
    }
}
