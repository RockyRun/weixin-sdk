package com.weixin.sdk.api;

import java.net.URLEncoder;

import org.junit.Ignore;
import org.junit.Test;

import com.weixin.sdk.AppSpecific;
import com.weixin.sdk.Client;
import com.weixin.sdk.ResponseStatus;
import com.weixin.sdk.menu.ComposableMenuItem;
import com.weixin.sdk.menu.Menu;
import com.weixin.sdk.menu.ViewableMenuItem;

public class MenuTest extends WeixinAPITest{
    
    
//    String openID = "donny.xie|yuqing.jiang";
    String openID = "donny.xie";
    
    
    @Test
    public void testCreateMenu(){
        Menu menu = createMenu();
        Client client = new Client(new AppSpecific(appID, appSecret, null));

        ResponseStatus status = client.createMenu(menu, "6");
        System.out.println(status);
        
        
    }
    
    private Menu createMenu() {
        Menu menu = new Menu();

        ViewableMenuItem today = new ViewableMenuItem("表现", redirectURL("http://wxjava.donnior.me/homeworks"));
        ViewableMenuItem tuozhan = new ViewableMenuItem("拓展", redirectURL("http://wxjava.donnior.me/yuer"));
        ComposableMenuItem item3 = new ComposableMenuItem("个人");
        ViewableMenuItem nav = new ViewableMenuItem("导航", redirectURL("http://wxjava.donnior.me/nav"));
        ViewableMenuItem setting = new ViewableMenuItem("设置", redirectURL("http://wxjava.donnior.me/setting"));
        
        item3.addSubMenuItem(nav);
        item3.addSubMenuItem(setting);
        
        menu.addMenuItem(today);
//        menu.addMenuItem(tuozhan);
//        menu.addMenuItem(item3);
        return menu;
    }
    
    private Menu createMenu2() {
        Menu menu = new Menu();
        
        ComposableMenuItem item1 = new ComposableMenuItem("消息");
        
        ViewableMenuItem contacts = new ViewableMenuItem("通讯录", redirectURL("http://wxjava.donnior.me/contacts"));
        ViewableMenuItem qingjia = new ViewableMenuItem("请假", redirectURL("http://wxjava.donnior.me/qingjia"));
        ViewableMenuItem chat = new ViewableMenuItem("对话", redirectURL("http://wxjava.donnior.me/chat"));
        
        item1.addSubMenuItem(contacts);
        item1.addSubMenuItem(qingjia);
        item1.addSubMenuItem(chat);
        
        ComposableMenuItem item2 = new ComposableMenuItem("花园");
        
        ViewableMenuItem yuer = new ViewableMenuItem("育儿", redirectURL("http://wxjava.donnior.me/yuer"));
        ViewableMenuItem discuz = new ViewableMenuItem("七嘴八舌", redirectURL("http://wxjava.donnior.me/discuz"));
        
        item2.addSubMenuItem(yuer);
        item2.addSubMenuItem(discuz);

        ComposableMenuItem item3 = new ComposableMenuItem("个人");
        
        ViewableMenuItem nav = new ViewableMenuItem("导航", redirectURL("http://wxjava.donnior.me/nav"));
        ViewableMenuItem setting = new ViewableMenuItem("设置", redirectURL("http://wxjava.donnior.me/setting"));
        
        item3.addSubMenuItem(nav);
        item3.addSubMenuItem(setting);
        
        
        
        menu.addMenuItem(item1);
        menu.addMenuItem(item2);
        menu.addMenuItem(item3);
        return menu;
    }
    
    @Test
    @Ignore
    public void testEncodeURL(){
        System.out.println(redirectURL("http://www.donnior.me/contact"));
    }
    

    @SuppressWarnings("deprecation")
    private String redirectURL(String originalURL){
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
        return String.format(url, appID, URLEncoder.encode(originalURL));
    }
    
}
