package com.weixin.sdk.decoder;

import java.util.HashMap;
import java.util.Map;

public abstract class DecoderTest {

    protected Map<String, String> newRequestMap() {
        Map<String, String> map = new HashMap<String, String>();
        
        map.put("CreateTime", "1348831860");
        map.put("FromUserName", "FromUser");
        map.put("ToUserName", "ToUser");
        
        return map;
    }

}
