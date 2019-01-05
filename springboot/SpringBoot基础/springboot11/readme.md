- mq1-springboot 
  - JmsTemplate
  - JmsMessagingTemplate 进一步封装
  - `spring.jms.pub-sub-domain` springboot统一消息的设置P2P、pub/sub (不好用，不建议用)
  - `@JmsListener` 监听消息，默认监听队列，跟随第三种的设置

- mq2-springboot/mq3-springboot
  - `DefaultJmsListenerContainerFactory` 默认消息监听容器工厂

- mq4-springboot
  - 自定义多个jmsTemplate，目前事物不生效