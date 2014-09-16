package com.weixin.sdk.custom;

import org.json.JSONObject;

public class ImageCustomMessage implements CustomMessage{

    private String toUser;
    private String image;
    private String agentID;
    
    public ImageCustomMessage(String toUser, String image) {
        this.toUser = toUser;
        this.image = image;
         
    }
    
    @Override
    public String toJson() {
        JSONObject json = new JSONObject();
        json.put("agentid", this.getAgentID());
        json.put("touser", this.getToUser());
        json.put("msgtype", "image");
        
        JSONObject textObj = new JSONObject().put("media_id", this.getImage());
        json.put("image", textObj);
        
        return json.toString();
    }
    
    public String getImage() {
        return image;
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
