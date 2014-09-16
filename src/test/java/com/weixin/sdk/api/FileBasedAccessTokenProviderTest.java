package com.weixin.sdk.api;

import org.junit.Test;

import com.weixin.sdk.AccessToken;
import com.weixin.sdk.AccessTokenStorager;
import com.weixin.sdk.FileBasedAccessTokenStorager;

public class FileBasedAccessTokenProviderTest {

    @Test
    public void testGet(){
        AccessToken at = new AccessToken("token string", (long)112324324);
        AccessTokenStorager ats = new FileBasedAccessTokenStorager();
//        ats.saveAccessToken(null, at);
        at = ats.loadAccessToken(null);
        System.out.println(at.getToken().equals("token string"));
        System.out.println(at.getExpiresAt() == 112324324);
    }
    
}
