package com.weixin.sdk.api;

import java.net.URLEncoder;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Strings;
import com.weixin.sdk.AppSpecific;
import com.weixin.sdk.Client;
import com.weixin.sdk.ResponseStatus;
import com.weixin.sdk.custom.ArticlesCustomMessage;
import com.weixin.sdk.custom.FileCustomMessage;
import com.weixin.sdk.custom.TextCustomMessage;
import com.weixin.sdk.response.ArticleItem;

public class SendMessagesTest extends WeixinAPITest{
    
//    String openID = "donny.xie|yuqing.jiang";
    String openID = "donny.xie|peng.xia";
    
    Client client;
    
    @Before
    public void setUp(){
        client = new Client(new AppSpecific(appID, appSecret, null));
    }
    
    @Test
    @Ignore
    public void testSendTextMessage(){
        ResponseStatus status = client.sendCustomMessage(new TextCustomMessage("1", openID, "http://wx.lexuetech.com/wx?echostr=123"));
        System.out.println(status);
        
    }

    @Test
//    @Ignore
    public void testPrepareMsg(){

        Client client = new Client(new AppSpecific(appID, appSecret, null));
        
        ArticlesCustomMessage msg = new ArticlesCustomMessage();
        ArticleItem item = new ArticleItem();
        
        String format = "%s\n\n本消息由 %s 发送";
        String descContent = "今年春游定于3月14日，地点是解放公园";
        
//        String desc = Joiner.on("\n\n").skipNulls().join("", "张书桥老师");
        
        String desc = String.format(format, Strings.nullToEmpty(descContent), "张书桥老师");
       
        item.setDescription(desc);
        
        item.setTitle("[三4班] 关于春游的通知");
        item.setUrl(client.redirectionURL("http://218.244.156.165/page/contacts", "stat1"));
//        item.setPicUrl("http://a.hiphotos.baidu.com/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=6c344b991f950a7b613846966bb809bc/f31fbe096b63f6244b5c29ac8544ebf81a4ca31f.jpg");
        msg.addArticle(item);
        
        msg.setToUser(openID);
        msg.setAgentID("1");
        
        ResponseStatus status = client.sendCustomMessage(msg);
        System.out.println(status);    
    }
    
    @Test
    @Ignore
    public void testPrepareMsg2(){

        Client client = new Client(new AppSpecific(appID, appSecret, null));
        

        ArticlesCustomMessage msg = new ArticlesCustomMessage();
        ArticleItem item = new ArticleItem();
        item.setDescription("李老师回复了您的消息2");
        item.setTitle("李老师回复了您的消息2");
        item.setUrl(null);
        item.setPicUrl(null);
        msg.addArticle(item);
        
        msg.setToUser(openID);
        msg.setAgentID("1");
        
        System.out.println(msg.toJson());
        
        ResponseStatus status = client.sendCustomMessage(msg);
        System.out.println(status);    
    }
    
    @Test
    @Ignore
    public void testSendFileMessage(){
        FileCustomMessage msg = new FileCustomMessage("1RmP-M2TyleU9cDUtPSUG8RmEffDPVd4cJBuId9n95Yje62oLesnYh8BX-0g_F7Pj");
        msg.setToUser(openID);
        msg.setAgentID("2");
        ResponseStatus status = client.sendCustomMessage(msg);
        System.out.println(status);
    }

    @SuppressWarnings("deprecation")
    private String redirectURL(String originalURL){
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
        return String.format(url, appID, URLEncoder.encode(originalURL));
    }
    
    @Test
    public void testURL(){
        String url = client.redirectionURL("http://218.244.156.165/weixin?echostr=ad", "state");
        System.out.println(url);
    }
    
}
