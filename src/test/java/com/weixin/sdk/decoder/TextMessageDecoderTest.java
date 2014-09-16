package com.weixin.sdk.decoder;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.weixin.sdk.Request;
import com.weixin.sdk.core.RequestImpl;
import com.weixin.sdk.message.TextMessage;

public class TextMessageDecoderTest extends DecoderTest{


    Decoder decoder = new TextMessageDecoder();
    
    @Test
    public void test(){
        Map<String, String> map = newRequestMap();
        
        map.put("MsgType", "text");
        Request request = new RequestImpl(map);
        
        assertFalse(decoder.support(request));
        
        map.put("Content", "haha");
        request = new RequestImpl(map);
        
        assertTrue(decoder.support(request));
        
        TextMessage tm = (TextMessage)decoder.decode(request);
        assertEquals("haha", tm.getContent());
    }
}
