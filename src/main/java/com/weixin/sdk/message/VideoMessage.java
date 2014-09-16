package com.weixin.sdk.message;

public class VideoMessage extends AbstractMediaMessage{

    private String thumbMediaId;
    
    @Override
    public MessageType messageType() {
        return MessageType.VIDEO;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }
    
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
    
}
