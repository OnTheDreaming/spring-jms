package com.jms.spring_jms.listener;

import com.jms.entity.OrderInfo;

/**
 * MessageListenerAdapter类实现了MessageListener接口和SessionAwareMessageListener接口，它的主要作用是将接收到的消息进行类型转换，然后通过反射的形式把它交给一个普通的Java类进行处理。

 MessageListenerAdapter会把接收到的消息做如下转换：

 TextMessage转换为String对象；

 BytesMessage转换为byte数组；

 MapMessage转换为Map对象；

 ObjectMessage转换为对应的Serializable对象
 */
public class ConsumerMessageListenerAdapt {
    /**
     *
     * 当我们没有指定通过MessageListenerAdapter的defaultListenerMethod属性时，
     * Spring会默认调用目标处理器的handleMessage方法
     * @param message
     */
    public void handleMessage(String message) {
        System.out.println("ConsumerMessageListenerAdapt通过f调用默认的handleMessage接收到一个纯文本消息，消息内容是：" + message);
    }

    /**
     * 指定MessageListenerAdapter的defaultListenerMethod属性为该方法时,该方法处理消息监听
     * @param message
     */
    public void receiveMessage(String message) {
        System.out.println("ConsumerMessageListenerAdapt通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);
    }
    /**
     * 当返回类型是非null时MessageListenerAdapter会自动把返回值封装成一个Message，然后进行回复
     * @param message
     * @return
     */
    public String receiveMessageAndRespone(String message) {
        System.out.println("ConsumerMessageListenerAdapt通过receiveMessageAndRespone接收到一个纯文本消息，消息内容是：" + message);
        return "这是ConsumerMessageListenerAdapt对象的receiveMessageAndRespone方法的返回值。";
    }

    /**
     * 类型转换后如果是OrderInfo 类调用此方法
     * @param orderInfo
     */
    public  void receiveMessage(OrderInfo orderInfo){
        System.out.println(orderInfo.getName());

    }
}
