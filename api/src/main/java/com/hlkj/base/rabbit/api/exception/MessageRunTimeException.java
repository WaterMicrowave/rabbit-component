package com.hlkj.base.rabbit.api.exception;

/**
 * 自定义运行时异常
 */
public class MessageRunTimeException extends RuntimeException{

    public MessageRunTimeException() {
        super();
    }

    public MessageRunTimeException(String message) {
        super(message);
    }

    public MessageRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageRunTimeException(Throwable cause) {
        super(cause);
    }

}
