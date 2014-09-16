package com.weixin.sdk;

import org.json.JSONObject;

public class User {
    
    public static enum Gender{
        MALE, FEMALE;
    }

    String userid;
    String name;
    Integer[] departments;
    String position;
    String mobile;
    String tel;
    String email;
    String weixinid;
    String qq;
    
    Gender gender;
    
    public User() {
    }
    
    public User(String userid, String name, String mobile, Integer[] departments){
        this.userid = userid;
        this.name = name;
        this.mobile = mobile;
        this.departments = departments;
    }

    public void setDepartments(Integer[] departments) {
        this.departments = departments;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    
    public void setQq(String qq) {
        this.qq = qq;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
    
    public void setWeixinid(String weixinid) {
        this.weixinid = weixinid;
    }
    
    public Integer[] getDepartments() {
        return departments;
    }
    
    public String getEmail() {
        return email;
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPosition() {
        return position;
    }
    
    public String getQq() {
        return qq;
    }
    public String getTel() {
        return tel;
    }
    
    public String getUserid() {
        return userid;
    }
    
    public String getWeixinid() {
        return weixinid;
    }
    
    public String toJson(){
        JSONObject json = new JSONObject();
        
        json.put("userid", this.userid);
        json.put("name", this.name);
        json.put("department", this.departments);
        json.put("mobile", this.mobile);
        
        json.put("position", this.position);
        json.put("email", this.email);
        json.put("tel", this.tel);
        json.put("weixinid", this.weixinid);
        json.put("gender", Gender.FEMALE.equals(this.gender) ? 0 : 1);
        
        return json.toString();
        
    }
    
}
