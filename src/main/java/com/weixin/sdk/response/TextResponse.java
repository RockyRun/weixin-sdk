package com.weixin.sdk.response;

import org.json.JSONObject;

public class TextResponse extends AbstractResponse{

    private String content;
    
    @Override
    public void appendCustomizeXMLContent(StringBuilder sb) {
        sb.append(xmlString("Content", this.content));
    }
    
    @Override
    public String messageTypeIdentifer() {
        return "text";
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String toJson2(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        
        sb.append("\"touser\" : \""+this.getToUser()+"\",");
        sb.append("\"msgtype\" : \"text\",");
        sb.append("\"text\" : ");
        
        sb.append("{");
        sb.append("\"content\" : \""+this.getContent()+"\",");
        sb.append("}");
        
        sb.append("}");
        return sb.toString();
    }
    
    public String toJson(){
        JSONObject json = new JSONObject();
        
        json.put("touser", this.getToUser());
        json.put("msgtype", "text");
        
        JSONObject textObj = new JSONObject().put("content", this.getContent());
        json.put("text", textObj);
        
        return json.toString();
    }
}
