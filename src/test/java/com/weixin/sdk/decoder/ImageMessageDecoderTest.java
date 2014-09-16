package com.weixin.sdk.decoder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.weixin.sdk.Request;
import com.weixin.sdk.core.RequestImpl;
import com.weixin.sdk.message.ImageMessage;

public class ImageMessageDecoderTest extends DecoderTest{


    Decoder decoder = new ImageMessageDecoder();
    
    @Test
    public void test(){
        Map<String, String> map = newRequestMap();

        Request request = new RequestImpl(map);
        
        assertFalse(decoder.support(request));
        
        String picUrl = "http://www.google.com/logo.png";
        map.put("MsgType", "image");
        map.put("PicUrl", picUrl);
        request = new RequestImpl(map);
        
        assertTrue(decoder.support(request));
        
        ImageMessage tm = (ImageMessage)decoder.decode(request);
        assertEquals(picUrl, tm.getPicUrl());
    }
}
