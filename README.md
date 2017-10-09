# spring-jms

  spring 整合jms demo实例
  <pre>------------------------
   *master 主干分支作为第一次提交 Jms API中的接口使用demo
    该主干分支作为jms基础知识的了解,demo展示了使用jms提供的标准API(ConnectionFactory,Message,MessageProduce,...)
    连接activeMQ的案例
   
   *branch_listener 分支  Spring整合JMS 三种消息监听器及其应用
   
    1.MessageListener是最原始的消息监听器，它是JMS规范中定义的一个接口.其中定义了一个用于处理接收到的消息的onMessage方法
      该方法只接收一个Message参数.在自定义监听器时只需要重写onMessage方法即可.
      <!-- 消息监听容器 -->  
    <bean id="jmsContainer"        
                         class="org.springframework.jms.listener.DefaultMessageListenerContainer">  
        <property name="connectionFactory" ref="connectionFactory" />  
        <property name="destination" ref="queueDestination" />  
        <property name="messageListener" ref="consumerMessageListener" />  
    </bean>  
    
    2.SessionAwareMessageListener是Spring为我们提供的,它不是标准的JMS MessageListener。
      MessageListener的设计只是纯粹用来接收消息的,假如我们在使用MessageListener处理接收到的消息时我们需要发送一个消息
      通知对方我们已经收到这个消息了，那么这个时候我们就需要在代码里面去重新获取一个Connection或Session。
      SessionAwareMessageListener的设计就是为了方便我们在接收到消息后发送一个回复的消息
      它同样为我们提供了一个处理接收到的消息的onMessage方法，但是这个方法可以同时接收两个参数，
      一个是表示当前接收到的消息Message，另一个就是可以用来发送消息的Session对象
       <!-- 消息监听容器 -->  
      <bean id="sessionAwareListenerContainer"  
        class="org.springframework.jms.listener.DefaultMessageListenerContainer">  
        <property name="connectionFactory" ref="connectionFactory" />  
        <property name="destination" ref="sessionAwareQueue" />  
        <property name="messageListener" ref="consumerSessionAwareMessageListener" />  
    </bean>  
    
    3.MessageListenerAdapter类实现了MessageListener接口和SessionAwareMessageListener接口，
      它的主要作用是将接收到的消息进行类型转换
      然后通过反射的形式把它交给一个普通的Java类进行处理(如果真正的目标处理器是一个MessageListener或者是一个SessionAwareMessageListener，那么Spring将直接使用接收到的Message对象作为参数调用它们的onMessage方法，而不会再利用反射去进行调用)。

       MessageListenerAdapter会把接收到的消息做如下转换：

       TextMessage转换为String对象；

       BytesMessage转换为byte数组；

       MapMessage转换为Map对象；

       ObjectMessage转换为对应的Serializable对象。
       
       如果指定的目标处理器是一个普通的Java类时Spring将利用Message进行了类型转换之后的对象作为参数通过反射去调用真正的目标处理器的处理方法,通过MessageListenerAdapter的defaultListenerMethod属性来决定,当我们没有指定该属性时，Spring会默认调用目标处理器的handleMessage方法
    <!-- 消息监听容器 -->  
        <bean id="messageListenerAdapterContainer" class="org.springframework.jms.listener.DefaultMessageListenerContainer">  
        <property name="connectionFactory" ref="connectionFactory"/>  
        <property name="destination" ref="adapterQueue"/>  
        <property name="messageListener" ref="messageListenerAdapter"/><!-- 使用MessageListenerAdapter来作为消息监听器 -->  
    </bean>  
    <!-- 消息监听适配器 -->  
    <bean id="messageListenerAdapter" class="org.springframework.jms.listener.adapter.MessageListenerAdapter">  
    <property name="delegate">  
        <bean class="com.tiantian.springintejms.listener.ConsumerListener"/>  
    </property>  
    <property name="defaultListenerMethod" value="receiveMessage"/>  
</bean>  
 </pre>
