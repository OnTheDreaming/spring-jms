package com.jms.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by caowenhui on 2017/9/16.
 */
public class TopicConsumer {

    private static  final String url="tcp://localhost:61616";//activeMQ地址
    private static  final String topicName="TOPIC_TEST";//队列名称
    private  static ConnectionFactory connectionFactory ;//连接工厂
    private  static Session session;//连接会话
    private  static Destination destination ;//目的地
    private  static MessageConsumer messageConsumer ;//消息消费者--消费者
    public static void main(String[] args)  {
        try {
            //创建连接工厂
            connectionFactory = new ActiveMQConnectionFactory(url);
            //创建连接
            Connection connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session会话
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建主题目的地)
            destination=session.createTopic(topicName);
            //创建一个消费者
            messageConsumer=session.createConsumer(destination);
            //消息监听器
            messageConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("接收消息:" + textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
