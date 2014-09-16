package com.weixin.sdk.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<MenuItem> menuItems;
    
    public Menu(){
        this.menuItems = new ArrayList<MenuItem>();
    }

    public void addMenuItem(MenuItem menuItem){
        this.menuItems.add(menuItem);
    }
    
    public String toJson(){
        StringBuilder sb = new StringBuilder();
        sb.append("{\"button\":");
        sb.append("[");
        
        for(int index = 0; index < menuItems.size(); index++){
            sb.append(menuItems.get(index).toJson());
            if(index < menuItems.size() -1){
                sb.append(",");
            }
        }
        
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }
    
}
