package com.hlkj.base.rabbit.producer.broker;

import com.hlkj.base.rabbit.api.Message;

/**
 * 具体发送不同消息的接口
 */
public interface RabbitBroker {

    void rapidSend(Message message);

    void confirmSend(Message message);

    void reliantSend(Message message);

    void sendMessages();//批量消息
}
