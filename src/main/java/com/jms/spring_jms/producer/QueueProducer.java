package com.jms.spring_jms.producer;

import com.jms.entity.OrderInfo;
import com.jms.services.SendDataServices;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

import javax.jms.Destination;

public class QueueProducer {

    private  static SendDataServices sendMessageImpl;

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("producer.xml");
        sendMessageImpl=(SendDataServices)  applicationContext.getBean("sendMessageImpl");
        /**
         * 测试SessionAwareMessageListener
         */
       // Destination destination=(Destination)applicationContext.getBean("sessionAwareDestination");
        /**
         * 测试MessageListenerAdapt
         */

        Destination destination=(Destination)applicationContext.getBean("queueDestination");

//        for (int i = 0; i <10 ; i++) {
//            sendMessageImpl.sendMessge(destination,"发送消息:" + i);
//            System.out.println("发送消息:"+i);
//        }
//        System.out.println("发送 测试SessionAwareMessageListener");
//        sendMessageImpl.sendMessge(destination, "测试SessionAwareMessageListener" );



//        System.out.println("发送 测试MessageListenerAdapt");
//        sendMessageImpl.sendMessge(destination, "测试MessageListenerAdapt");

        OrderInfo orderInfo=new OrderInfo();
        orderInfo.setName("Computer");
        sendMessageImpl.sendMessge(destination,orderInfo);
    }
}
