package com.weixin.sdk.message;

public abstract class AbstractMessage extends AbstractRecieved implements Message{

    private String messageId;
    
    public String messageId() {
        return this.messageId;
    }
    
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
    
}
