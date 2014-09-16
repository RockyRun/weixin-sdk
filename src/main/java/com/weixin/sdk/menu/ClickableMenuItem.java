package com.weixin.sdk.menu;

public class ClickableMenuItem implements MenuItem{
    
    private String name;
    private String key;
    
    public ClickableMenuItem(String name, String key){
        this.name = name;
        this.key = key;
    }
    
    @Override
    public String toJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"type\" : \"click\",");
        sb.append("\"name\" : \""+name+"\",");
        sb.append("\"key\" : \""+key+"\"");
        sb.append("}");
        return sb.toString();
    }
    
}
