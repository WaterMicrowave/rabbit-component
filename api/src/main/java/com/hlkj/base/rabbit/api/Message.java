package com.hlkj.base.rabbit.api;


import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 定义消息对象
 */
@Data
public class Message implements Serializable {

    /* 唯一的消息id */
    private String messageId;
    /* 消息的主体 */
    private String topic;
    /* 消息的路由规则 */
    private String routingKey = "";
    /* 消息的附加属性 */
    private Map<String, Object> attributes = new HashMap<>();

    /* 延迟消息的参数配置 */
    private int delayMills;
    /* 消息的类型(默认confirm类型) */
    private String messageType = MessageType.CONFIRM;

    public Message() {
    }

    public Message(String messageId, String topic, String routingKey, Map<String, Object> attributes, int delayMills) {
        this.messageId = messageId;
        this.topic = topic;
        this.routingKey = routingKey;
        this.attributes = attributes;
        this.delayMills = delayMills;
    }

    public Message(String messageId, String topic, String routingKey, Map<String, Object> attributes, int delayMills, String messageType) {
        this.messageId = messageId;
        this.topic = topic;
        this.routingKey = routingKey;
        this.attributes = attributes;
        this.delayMills = delayMills;
        this.messageType = messageType;
    }

}
