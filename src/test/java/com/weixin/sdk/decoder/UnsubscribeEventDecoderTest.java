package com.weixin.sdk.decoder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.weixin.sdk.Request;
import com.weixin.sdk.core.RequestImpl;
import com.weixin.sdk.message.UnsubscribeEvent;

public class UnsubscribeEventDecoderTest extends DecoderTest{


    Decoder decoder = new UnsubscribEventDecoder();
    
    @Test
    public void test(){
        Map<String, String> map = newRequestMap();
        
        map.put("MsgType", "event");
        Request request = new RequestImpl(map);
        
        assertFalse(decoder.support(request));
        
        map.put("Event", "unsubscribe");
        request = new RequestImpl(map);
        
        assertTrue(decoder.support(request));
        assertTrue(decoder.decode(request).getClass().equals(UnsubscribeEvent.class));
    }
}
