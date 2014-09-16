package com.weixin.sdk.decoder;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.AbstractRecieved;
import com.weixin.sdk.message.TextMessage;
import com.weixin.sdk.message.Receivable;

public class TextMessageDecoder extends AbstractDecoder{

    private final String EXPECTED_TYPE = "text";
    public static final String KEY_FOR_CONTENT = "Content";
    
    @Override
    public boolean support(Request request) {
        return isRequestMatchMessageType(request, EXPECTED_TYPE) 
                && request.contains(KEY_FOR_CONTENT);
    }

    @Override
    void decodeMoreProperty(AbstractRecieved recieved, Request request) {
        TextMessage message = (TextMessage)recieved;
        message.setMessageId(request.get(KEY_FOR_MSG_ID));
        message.setContent(request.get(KEY_FOR_CONTENT));
    }
    
    @Override
    Receivable newInstance() {
        return new TextMessage();
    }
    
}
