package com.weixin.sdk.message;

public enum EventType {

    SUBSCRIBE("subscribe"),
    
    UNSUBSCRIBE("unsubscribe"),
    
    SCAN("SCAN"),
    
    LOCATION("LOCATION"),
    
    CLICK("CLICK"),
    
    VIEW("VIEW"), 
    
    VERIFY("verify");
    
    private String desc;
    
    private EventType(String desc){
        this.desc = desc;
    }
    
    public String getDesc() {
        return desc;
    }
}
