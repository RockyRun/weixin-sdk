package com.weixin.sdk.api;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.weixin.sdk.AppSpecific;
import com.weixin.sdk.Client;
import com.weixin.sdk.ResponseStatus;
import com.weixin.sdk.department.Department;

public class DepartmentTest extends WeixinAPITest{
    
    
//    String openID = "donny.xie|yuqing.jiang";
    String openID = "donny.xie";
    
    Client client;
    
    @Before
    public void setUp(){
        client = new Client(new AppSpecific(appID, appSecret, null));
    }
    
    @Test
    @Ignore
    public void testCreateDepartment(){        
        
        Department dpt = new Department("Test", "2");
        
        ResponseStatus status = client.createDepartment(dpt);
        System.out.println(status);
    }
    
    
    @Test
    @Ignore
    public void testUpdateDepartment(){        
        
        Department dpt = new Department("2");
        dpt.setName("教师");
        
        ResponseStatus status = client.updateDepartment(dpt);
        System.out.println(status);
    }
    
    @Test
    @Ignore
    public void testDeleteDepartment(){        
        Department dpt = new Department("3");
        
        ResponseStatus status = client.deleteDepartment(dpt);
        System.out.println(status);
    }

    @Test
    public void testListDepartment(){        
        ResponseStatus status = client.listDepartment();
        System.out.println(status);
    }
    
}
