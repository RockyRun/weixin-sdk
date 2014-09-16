package com.weixin.sdk;

public interface AccessTokenStorager {

    void saveAccessToken(AppSpecific appSpecific, AccessToken accessToken);
    
    AccessToken loadAccessToken(AppSpecific appSpecific);
    
}
