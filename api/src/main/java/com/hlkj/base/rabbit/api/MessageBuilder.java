package com.hlkj.base.rabbit.api;

import com.hlkj.base.rabbit.api.exception.MessageRunTimeException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 建造者模式
 */
public class MessageBuilder {
    /**
     * 属性必须和被建造者一致
     */
    private String messageId;
    private String topic;
    private String routingKey = "";
    private Map<String, Object> attributes = new HashMap<>();
    private int delayMills;
    private String messageType = MessageType.CONFIRM;

    /**
     * 构造方法私有化
     */
    private MessageBuilder() {
    }

    public static MessageBuilder create() {
        return new MessageBuilder();
    }

    public MessageBuilder withMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    public MessageBuilder withTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public MessageBuilder withRoutingKey(String routingKey) {
        this.routingKey = routingKey;
        return this;
    }

    public MessageBuilder withAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
        return this;
    }

    public MessageBuilder withAttribute(String key, Object value) {
        this.attributes.put(key, value);
        return this;
    }

    public MessageBuilder withDelayMills(int delayMills) {
        this.delayMills = delayMills;
        return this;
    }

    public MessageBuilder withMessageType(String messageType) {
        this.messageType = messageType;
        return this;
    }

    public Message build() {
        //1、补偿：当messageId为null时，使用uuid
        if (messageId == null) {
            messageId = UUID.randomUUID().toString();
        }
        //2、预判：当topic为null时，抛出异常，阻断程序的继续运行
        if (topic == null) {
            throw new MessageRunTimeException("this topic is null ");
        }
        Message message = new Message(messageId, topic, routingKey, attributes, delayMills, messageType);
        return message;
    }

}
