package com.weixin.sdk.message;

public abstract class AbstractMediaMessage extends AbstractMessage{

    private String mediaId;
    
    public String getMediaId() {
        return mediaId;
    }
    
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
    
}
