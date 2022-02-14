package com.hlkj.base.rabbit.producer.broker;

import com.hlkj.base.rabbit.api.Message;
import com.hlkj.base.rabbit.api.MessageProducer;
import com.hlkj.base.rabbit.api.SendCallBack;
import com.hlkj.base.rabbit.api.exception.MessageRunTimeException;

import java.util.List;

public class ProducerClient implements MessageProducer {

    @Override
    public void send(Message message) throws MessageRunTimeException {

    }

    @Override
    public void send(Message message, SendCallBack sendCallBack) throws MessageRunTimeException {

    }

    @Override
    public void send(List<Message> messages) throws MessageRunTimeException {

    }
}
