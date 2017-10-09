package com.jms.spring_jms.listener;



import com.jms.entity.OrderInfo;
import com.jms.messageConvert.OrderMessageConvert;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * MessageListener是最原始的消息监听器，它是JMS规范中定义的一个接口。
 * 其中定义了一个用于处理接收到的消息的onMessage方法，该方法只接收一个Message参数
 */
public class ConsumerListeer implements MessageListener {
    @Autowired
    private OrderMessageConvert orderMessageConvert;
    @Override
    public void onMessage(Message message) {
        try {
           OrderInfo orderInfo=(OrderInfo) orderMessageConvert.fromMessage(message);
            System.out.println(orderInfo.getName());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
