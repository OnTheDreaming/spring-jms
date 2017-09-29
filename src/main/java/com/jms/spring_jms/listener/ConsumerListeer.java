package com.jms.spring_jms.listener;



import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * MessageListener是最原始的消息监听器，它是JMS规范中定义的一个接口。
 * 其中定义了一个用于处理接收到的消息的onMessage方法，该方法只接收一个Message参数
 */
public class ConsumerListeer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage=(TextMessage)message;
        try {
            System.out.println("ConsumerListeer接收消息到的消息为:"+textMessage.getText());
        }catch ( JMSException e){
            e.printStackTrace();
        }
    }
}
