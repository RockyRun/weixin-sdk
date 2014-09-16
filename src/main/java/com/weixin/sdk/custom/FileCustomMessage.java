package com.weixin.sdk.custom;

import org.json.JSONObject;

public class FileCustomMessage implements CustomMessage{
    
    private String toUser;
    
    private String agentID;

    private String mediaID;
    
    public FileCustomMessage(String mediaID) {
        this.mediaID = mediaID;
    }
    
    @Override
    public String toJson() {
        JSONObject json = new JSONObject();
        
        json.put("touser", this.getToUser());
        json.put("msgtype", "file");
        
        JSONObject fileObj = new JSONObject();
        
        fileObj.put("media_id", this.mediaID);
        json.put("file", fileObj);
        json.put("agentid", this.agentID);
        
        return json.toString();
    }
    
    public String getToUser() {
        return toUser;
    }

    public void setToUser(String user) {
        this.toUser = user;
    }

    @Override
    public void setAgentID(String agentID){
        this.agentID = agentID;
    }
    
    @Override
    public String getAgentID() {
        return this.agentID;
    }
}
