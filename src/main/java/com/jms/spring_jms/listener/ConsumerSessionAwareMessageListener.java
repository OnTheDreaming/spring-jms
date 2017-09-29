package com.jms.spring_jms.listener;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.annotation.Resource;
import javax.jms.*;

    /**
     *
     * SessionAwareMessageListener的设计就是为了方便我们在接收到消息后发送一个回复的消息，
        它同样为我们提供了一个处理接收到的消息的onMessage方法，但是这个方法可以同时接收两个参数，
        一个是表示当前接收到的消息Message，另一个就是可以用来发送消息的Session对象
    */
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<TextMessage> {
    @Resource(name = "queueDestination")
    private Destination destination;
    @Override
    public void onMessage(TextMessage textMessage, Session session) throws JMSException {
        System.out.println("ConsumerSessionAwareMessageListener接收到的消息为:" + textMessage.getText());
        MessageProducer producer=session.createProducer(destination);
        TextMessage responeMessage=session.createTextMessage("ConsumerSessionAwareListener返回的消息");
        producer.send(responeMessage);


    }
}
