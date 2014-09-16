package com.weixin.sdk.message;

public class LinkMessage extends AbstractMessage{
    
    private String title;
    private String description;
    private String url;
    
    @Override
    public MessageType messageType() {
        return MessageType.LINK;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
           
}
