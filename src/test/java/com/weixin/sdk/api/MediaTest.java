package com.weixin.sdk.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.weixin.sdk.AppSpecific;
import com.weixin.sdk.Client;
import com.weixin.sdk.MediaType;
import com.weixin.sdk.ResponseStatus;

public class MediaTest extends WeixinAPITest{
    
    Client client;
    
    @Before
    public void setUp(){
        client = new Client(new AppSpecific(appID, appSecret, null));
    }
    
    
    @Test
    @Ignore
    public void testUploadImage() throws FileNotFoundException{        
        File file = new File("/Users/donnior/Downloads/673acacegw1eejnk7ap5aj20c80feack.jpg");
        InputStream is = new FileInputStream(file);
        ResponseStatus rs = client.uploadMedia(is,"test.jpg", MediaType.IMAGE);
        System.out.println(rs);
    }

    @Test
    public void testGetImage() throws FileNotFoundException{        
        client.getMediaFile("1RmP-M2TyleU9cDUtPSUG8RmEffDPVd4cJBuId9n95Yje62oLesnYh8BX-0g_F7Pj");
    }
 
    
}
