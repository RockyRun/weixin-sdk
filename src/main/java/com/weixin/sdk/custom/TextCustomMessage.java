package com.weixin.sdk.custom;

import org.json.JSONObject;

public class TextCustomMessage implements CustomMessage{

    private String toUser;
    private String content;
    private String agentID;
    
    public TextCustomMessage(String toUser, String content) {
        this.toUser = toUser;
        this.content = content;
         
    }
    
    public TextCustomMessage(String agentID, String toUser, String content) {
        this(toUser, content);
        this.agentID = agentID;
    }
    
    @Override
    public String toJson() {
        JSONObject json = new JSONObject();
        
        json.put("agentid", this.getAgentID());
        json.put("touser", this.getToUser());
        json.put("msgtype", "text");
        
        
        JSONObject textObj = new JSONObject().put("content", this.getContent());
        json.put("text", textObj);
        
        return json.toString();
    }
    
    public String getContent() {
        return content;
    }
    
    public String getToUser() {
        return toUser;
    }

    @Override
    public String getAgentID() {
        return this.agentID;
    }

    @Override
    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }
}
