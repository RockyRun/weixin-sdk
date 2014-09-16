package com.weixin.sdk.response;

public class EmptyResponse implements Response{

    public static final EmptyResponse instance = new EmptyResponse();
    
    @Override
    public String toXML() {
        return "";
    }
    
    @Override
    public Integer getCreateTime() {
        return null;
    }
    
    @Override
    public String getFromUser() {
        return null;
    }
    
    @Override
    public String getToUser() {
        return null;
    }
    
}
