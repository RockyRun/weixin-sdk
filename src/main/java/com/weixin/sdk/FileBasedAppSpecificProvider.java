package com.weixin.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 使用于整个应用只支持一个公众号的情形，此时直接从配置文件app_specific.properties中读取公众号的应用信息；
 * 
 * 配置文件中需包含 appId, appSecrect, token
 * 
 */
public class FileBasedAppSpecificProvider implements AppSpecificProvider{

    private AppSpecific appSpecific;
    private String file = "app_specific.properties";
    
    
    public FileBasedAppSpecificProvider(){
        
        Properties prop = new Properties();
        InputStream input = null;
 
        try {
            input = FileBasedAppSpecificProvider.class.getClassLoader().getResourceAsStream(file);
            if(input==null){
                    System.out.println("Sorry, unable to find " + file);
                return;
            }

            prop.load(input);

            String appId = prop.getProperty("appId");
            String appSecret = prop.getProperty("appSecret");
            String token = prop.getProperty("token");

            this.appSpecific = new AppSpecific(appId, appSecret, token);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    /**
     * 根据微信的每次请求获得app信息，适用于应用支持多个公众号的情况；一般根据url中的参数来进行到不同
     * 公众号的匹配 
     */
    public AppSpecific getApp(Environment env){
        return this.appSpecific;
    }
    
}
