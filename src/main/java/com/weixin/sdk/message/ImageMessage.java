package com.weixin.sdk.message;

public class ImageMessage extends AbstractMediaMessage{

    private String picUrl;
    
    @Override
    public MessageType messageType() {
        return MessageType.IMAGE;
    }

    public String getPicUrl() {
        return picUrl;
    }
    
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    
}
