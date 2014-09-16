package com.weixin.sdk;


public class AccessToken {

    String token;
    long expiresAt;
    
    public AccessToken(String token, long createdAt, long expiresIn){
        this(token, createdAt + expiresIn);
    }
    
    public AccessToken(String accessToken, Long expireAt) {
        this.token = accessToken;
        this.expiresAt = expireAt;
    }

    public String getToken() {
        return token;
    }
    
    public boolean aviableFor(long timeStamp){
        return this.expiresAt > timeStamp;
    }

    public long getExpiresAt() {
        return this.expiresAt;
    }
}
