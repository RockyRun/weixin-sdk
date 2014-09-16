package com.weixin.sdk.api;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.weixin.sdk.AppSpecific;
import com.weixin.sdk.Client;
import com.weixin.sdk.ResponseStatus;
import com.weixin.sdk.User;
import com.weixin.sdk.User.Gender;

public class UserTest extends WeixinAPITest{
    
    
//    String openID = "donny.xie|yuqing.jiang";
    String openID = "donny.xie";
    
    Client client;
    
    @Before
    public void setUp(){
        client = new Client(new AppSpecific(appID, appSecret, null));
    }
    
    @Test
    @Ignore
    public void testCreateUser(){        
        
        User user = new User("test.user", "dongming.xie", "18086685512", new Integer[]{1,2});
        user.setEmail("dnnxie@qq.com");
        user.setGender(Gender.FEMALE);
        user.setTel("929832893");
        user.setWeixinid("donnior");
        user.setPosition("UFO");
        
        ResponseStatus status = client.createUser(user);
        System.out.println(status);
    }
    
    
    @Test
    @Ignore
    public void testUpdateUser(){        
        User user = new User("test.user", "dongming.xie", "18086685512", new Integer[]{2});
        user.setEmail("dnnxie@qq.com");
        user.setGender(Gender.FEMALE);
        user.setTel("929832893");
        user.setWeixinid("donnior");
        user.setPosition("UFO1");
        
        ResponseStatus status = client.updateUser(user);
        System.out.println(status);
    }
    
    @Test
    @Ignore
    public void testDeleteUser(){        
        
        ResponseStatus status = client.deleteUser("test.user");
        System.out.println(status);
    }

    @Test
    @Ignore
    public void testGetUser(){
        ResponseStatus status = client.getUserInfo("test.user");
        System.out.println(status);
    }
    
    @Test
//    @Ignore
    public void testListDepartment(){        
        ResponseStatus status = client.listUsers("1", true);
        System.out.println(status);
    }
    
}
