package com.weixin.sdk.menu;

import java.util.ArrayList;
import java.util.List;

public class ComposableMenuItem implements MenuItem{
    
    private String name;
    private List<MenuItem> items = new ArrayList<MenuItem>();
    
    public ComposableMenuItem(String name) {
        this.name = name;
    }
    
    public void addSubMenuItem(MenuItem menuItem){
        this.items.add(menuItem);
    }
    
    @Override
    public String toJson() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("{");
        sb.append("\"name\" : \""+name+"\",");
        sb.append("\"sub_button\":");
        sb.append("[");
        
        for(int index = 0; index < items.size(); index++){
            sb.append(items.get(index).toJson());
            if(index < items.size() -1){
                sb.append(",");
            }
        }
        
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }
    
}
