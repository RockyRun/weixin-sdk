package com.weixin.sdk.custom;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.weixin.sdk.response.ArticleItem;

public class ArticlesCustomMessage implements CustomMessage{
    
    private String toUser;
    

    private List<ArticleItem> articles = new ArrayList<ArticleItem>();


    private String agentID;
    
    public void addArticle(ArticleItem item){
        this.articles.add(item);
    }
    
    @Override
    public String toJson() {
        JSONObject json = new JSONObject();
        
        json.put("touser", this.getToUser());
        json.put("msgtype", "news");
        
        JSONObject newsObj = new JSONObject();
        JSONArray articles = new JSONArray();
        for(ArticleItem item : this.articles){
            articles.put(item.asJSONObject());
        }
        
        newsObj.put("articles", articles);
        json.put("news", newsObj);
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
