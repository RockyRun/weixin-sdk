package com.weixin.sdk.message;

public class TextMessage extends AbstractMessage{

    private String content;
    
    @Override
    public MessageType messageType() {
        return MessageType.TEXT;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
