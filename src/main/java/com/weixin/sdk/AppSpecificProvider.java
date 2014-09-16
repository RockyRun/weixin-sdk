package com.weixin.sdk;

public interface AppSpecificProvider {

    /**
     * 根据微信的每次请求获得app信息，适用于应用支持多个公众号的情况；一般根据url中的参数来进行到不同
     * 公众号的匹配 
     */
    AppSpecific getApp(Environment env);
    
}
