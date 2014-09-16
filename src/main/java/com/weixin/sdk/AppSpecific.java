package com.weixin.sdk;

/**
 * APP标识，每个app根据由AppID标识，用户的应用可能要支持多个公众号，
 * 因此需要根据不同的公众号来管理各自的token，或者获取accesstoken等等
 * 
 */
public class AppSpecific {

    private String appID;
    private String secret;
    private String token;

    public AppSpecific(String appID, String secret, String token){
        this.appID = appID;
        this.secret = secret;
        this.token = token;
    }
    
    public String getAppID() {
        return appID;
    }
    
    public String getSecret() {
        return secret;
    }
    
    public void setAppID(String appID) {
        this.appID = appID;
    }
    
    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken() {
        return this.token;
    }
    
}
