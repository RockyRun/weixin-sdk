package com.weixin.sdk.message;

public enum MessageType {

    TEXT("text"),
    
    IMAGE("image"),
    
    VOICE("voice"),
    
    VIDEO("video"),
    
    LOCATION("location"),
    
    LINK("link"),
    
    EVENT("event");
    
    private String desc;

    private MessageType(String desc){
        this.desc = desc;
    }
    
    public String getDesc() {
        return desc;
    }
    
}
