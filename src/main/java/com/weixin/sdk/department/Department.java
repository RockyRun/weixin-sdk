package com.weixin.sdk.department;


import org.json.JSONObject;

public class Department {

    
    private String name;
    private String parentID;
    private String id;

    public Department(String name, String parentID) {
        this.name = name;
        this.parentID = parentID;
    }
    
    public Department(String id){
        this.id = id;
    }
    
    public String toJson() {
        JSONObject json = new JSONObject();
        
        json.put("name", this.name);
        json.put("parentid", this.parentID);
        
        return json.toString();
    }

    public String toUpdateJson() {
        JSONObject json = new JSONObject();
        
        json.put("name", this.name);
        json.put("id", this.id);
        
        return json.toString();
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
}
