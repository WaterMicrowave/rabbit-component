package com.hlkj.base.rabbit.api;

public final class MessageType {

    /**
     * 迅速消息：不需要保障消息的可靠性，也不需要做confirm确认
     */
    public final static String RAPID = "0";

    /**
     * 确认消息：不需要保障消息的可靠性，但是会做消息confirm确认
     */
    public final static String CONFIRM = "1";

    /**
     * 可靠性消息：一定要保障消息的100%可靠性投递——不允许有任何消息的丢失
     *  PS：数据落库，状态打标。 也就是保障数据库和所发消息是原子性的（最终一致的）
     */
    public final static String RELIANT = "2";

}
