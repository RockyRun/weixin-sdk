package com.weixin.sdk;

/**
 * 使用于整个应用只支持一个公众号的情形，此时可以直接硬编码公众号信息至代码文件或者配置文件中
 * 
 */
public class GlobalAppSpecificProvider implements AppSpecificProvider{

    /**
     * 根据微信的每次请求获得app信息，适用于应用支持多个公众号的情况；一般根据url中的参数来进行到不同
     * 公众号的匹配 
     */
    public AppSpecific getApp(Environment env){
        return null;
    }
    
}
