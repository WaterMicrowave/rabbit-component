package com.hlkj.base.rabbit.producer.broker;

import com.google.common.base.Preconditions;
import com.hlkj.base.rabbit.api.Message;
import com.hlkj.base.rabbit.api.MessageProducer;
import com.hlkj.base.rabbit.api.MessageType;
import com.hlkj.base.rabbit.api.SendCallBack;
import com.hlkj.base.rabbit.api.exception.MessageRunTimeException;

import javax.annotation.Resource;
import java.util.List;

public class ProducerClient implements MessageProducer {


    @Resource
    private RabbitBroker rabbitBroker;

    @Override
    public void send(Message message) throws MessageRunTimeException {
        Preconditions.checkNotNull(message.getTopic());
        String messageType = message.getMessageType();
        switch (messageType) {
            case MessageType.RAPID:
                rabbitBroker.rapidSend(message);
                break;
            case MessageType.CONFIRM:
                rabbitBroker.confirmSend(message);
                break;
            case MessageType.RELIANT:
                rabbitBroker.reliantSend(message);
                break;
            default:
                break;
        }
    }

    @Override
    public void send(List<Message> messages) throws MessageRunTimeException {

    }

    @Override
    public void send(Message message, SendCallBack sendCallBack) throws MessageRunTimeException {

    }
}
