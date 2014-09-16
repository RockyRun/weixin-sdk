package com.weixin.sdk.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.weixin.sdk.Request;

public class RequestParserTest {

    private RequestParser parser = new DefaultRequestParser();
    
    @Test
    public void testParseTextRequest(){
        String file = "text_message.file";
        String content = FileUtils.contentFromFile(file);
        Request request = parser.parse(content);
        assertTrue(request.contains("MsgType"));
        assertTrue(request.contains("ToUserName"));
        assertTrue(request.contains("FromUserName"));
        assertEquals("1398adlfj9jlakdsjf", request.get("ToUserName"));
        assertEquals("this is a test", request.get("Content"));
    }
        
}
