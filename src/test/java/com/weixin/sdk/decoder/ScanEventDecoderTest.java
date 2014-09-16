package com.weixin.sdk.decoder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.weixin.sdk.Request;
import com.weixin.sdk.core.RequestImpl;
import com.weixin.sdk.message.ScanEvent;

public class ScanEventDecoderTest extends DecoderTest{


    Decoder decoder = new ScanEventDecoder();
    
    @Test
    public void test(){
        Map<String, String> map = newRequestMap();
        
        map.put("MsgType", "event");
        Request request = new RequestImpl(map);
        
        assertFalse(decoder.support(request));
        
        map.put("Event", "SCAN");
        map.put("EventKey", "eventKey");
        request = new RequestImpl(map);
        
        assertTrue(decoder.support(request));
        
        ScanEvent event = (ScanEvent)decoder.decode(request);
        assertEquals("eventKey", event.getEventKey());
    }
}
