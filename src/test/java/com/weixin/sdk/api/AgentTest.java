package com.weixin.sdk.api;

import org.junit.Before;
import org.junit.Test;

import com.weixin.sdk.AppSpecific;
import com.weixin.sdk.Client;
import com.weixin.sdk.ResponseStatus;

public class AgentTest extends WeixinAPITest{
    
    Client client;
    
    @Before
    public void setUp(){
        client = new Client(new AppSpecific(appID, appSecret, null));
    }
    
    
    @Test
    public void testListDepartment(){        
        ResponseStatus status = client.getAgent("2");
        System.out.println(status);
    }
    
}
