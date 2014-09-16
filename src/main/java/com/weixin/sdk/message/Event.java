package com.weixin.sdk.message;

/**
 * 
 *  微信推送给开发者的事件消息，除了消息类型为event之外，每则消息还有event type
 */
public interface Event extends Receivable{

    EventType getEventType();
    
}
