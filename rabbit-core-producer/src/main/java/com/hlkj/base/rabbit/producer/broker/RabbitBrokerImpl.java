package com.hlkj.base.rabbit.producer.broker;

import com.hlkj.base.rabbit.api.Message;
import com.hlkj.base.rabbit.api.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitBrokerImpl implements RabbitBroker {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void rapidSend(Message message) {
        message.setMessageType(MessageType.RAPID);
        sendKernel(message);
    }

    /**
     * 发送消息的核心方法 使用异步线程池进行发送消息
     * @param message
     */
    private void sendKernel(Message message) {
        //异步提交
        AsyncBaseQueue.submit((Runnable) ()->{
            String topic = message.getTopic();
            String messageId = message.getMessageId();
            String routingKey = message.getRoutingKey();

            CorrelationData c = new CorrelationData(String.format("%s#%s",
                    messageId, System.currentTimeMillis()));
            rabbitTemplate.convertAndSend(topic, routingKey, message, c);
            log.info("#RabbitBrokerImpl.sendKernel# send to rabbitmq, messageId: {}",  messageId);
        });
    }

    @Override
    public void confirmSend(Message message) {

    }

    @Override
    public void reliantSend(Message message) {

    }

    @Override
    public void sendMessages() {

    }
}
