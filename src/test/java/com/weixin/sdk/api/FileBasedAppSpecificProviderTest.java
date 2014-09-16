package com.weixin.sdk.api;

import org.junit.Test;

import com.weixin.sdk.AppSpecificProvider;
import com.weixin.sdk.FileBasedAppSpecificProvider;

public class FileBasedAppSpecificProviderTest {
    
    @Test
    public void testMenuToJson(){
        AppSpecificProvider provider = new FileBasedAppSpecificProvider();
        provider.getApp(null);
    }

}
