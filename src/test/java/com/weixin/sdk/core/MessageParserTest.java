package com.weixin.sdk.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.ImageMessage;
import com.weixin.sdk.message.TextMessage;
import com.weixin.sdk.message.Receivable;

public class MessageParserTest {

    private RequestParser parser = new DefaultRequestParser();
    
    @Test
    public void testParseTextRequest(){
        String file = "text_message.file";
        String content = FileUtils.contentFromFile(file);
        Request request = parser.parse(content);
        
        Receivable parsed = new DefaultMessageParser().parse(request);
        
        assertEquals(TextMessage.class, parsed.getClass());
        
        TextMessage message = (TextMessage)parsed;
        assertEquals(1348831860, message.createTime());
        assertEquals("this is a test", message.getContent());
    }

    @Test
    public void testParseImageRequest(){
        String file = "image_message.file";
        String content = FileUtils.contentFromFile(file);
        Request request = parser.parse(content);
        
        Receivable parsed = new DefaultMessageParser().parse(request);
        
        assertEquals(ImageMessage.class, parsed.getClass());
        
        ImageMessage message = (ImageMessage)parsed;
        assertEquals(1348831860, message.createTime());
        assertEquals("http://www.google.com/logo.png", message.getPicUrl());
    }

    
}
