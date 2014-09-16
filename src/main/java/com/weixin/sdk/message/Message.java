package com.weixin.sdk.message;

/**
 * 
 * 从微信服务器发送到开发者服务器的普通消息，即非事件消息
 */
public interface Message extends Receivable{

    String messageId();
    
}
