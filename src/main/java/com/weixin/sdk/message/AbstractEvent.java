package com.weixin.sdk.message;

public abstract class AbstractEvent extends AbstractRecieved implements Event{
    
    @Override
    public MessageType messageType() {
        return MessageType.EVENT;
    }
    
}
