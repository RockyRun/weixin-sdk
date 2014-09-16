package com.weixin.sdk.message;

public class VoiceMessage extends AbstractMediaMessage{

    private String format;
    
    @Override
    public MessageType messageType() {
        return MessageType.VOICE;
    }

    public String getFormat() {
        return format;
    }
    
    public void setFormat(String format) {
        this.format = format;
    }
    
}
