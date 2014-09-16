package com.weixin.sdk.menu;

import org.json.JSONObject;

public class ViewableMenuItem implements MenuItem{
    
    private String name;
    private String url;
    
    public ViewableMenuItem(String name, String url){
        this.name = name;
        this.url = url;
    }
    
    @Override
    public String toJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"type\" : \"view\",");
        sb.append("\"name\" : \""+name+"\",");
        sb.append("\"url\" : \""+url+"\"");
        sb.append("}");
//        JSONObject json = new JSONObject();
//        json.put("type", "view");
//        json.put("name", name);
//        json.put("url", url);
//        return json.toString();
        return sb.toString();
    }
}
