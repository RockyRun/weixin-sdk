package com.weixin.sdk.custom;

/**
 * 
 * 可以作为客服消息发送的消息，根据微信的API发送时需要转换为json格式
 * 
 */
public interface CustomMessage {

    String toJson();
    
    String getAgentID();
    
    void setAgentID(String agentID);
    
}
