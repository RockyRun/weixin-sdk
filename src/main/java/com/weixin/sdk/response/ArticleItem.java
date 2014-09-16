package com.weixin.sdk.response;

import org.json.JSONObject;

public class ArticleItem {

    private String title;
    private String description;
    private String picUrl;
    private String url;
    
    public String toXML(){
        StringBuilder sb = new StringBuilder();
        sb.append("<item>");
        sb.append("<Title>" + this.title + "</Title>");
        sb.append("<Description>" + this.description + "</Description>");
        sb.append("<PicUrl>" + this.picUrl + "</PicUrl>");
        sb.append("<Url>" + this.url + "</Url>");
        sb.append("</item>");
        return sb.toString();
    }
    
    public JSONObject asJSONObject(){
        JSONObject json = new JSONObject();
        
        json.put("title", this.title);
        json.put("description", this.description);
        json.put("picurl", this.picUrl);
        json.put("url", this.url);
        
        return json;
    }
    
    public String toJSON(){
        return asJSONObject().toString();
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getPicUrl() {
        return picUrl;
    }
    
     public String getTitle() {
        return title;
    }
     
     public String getUrl() {
        return url;
    }
    
}
