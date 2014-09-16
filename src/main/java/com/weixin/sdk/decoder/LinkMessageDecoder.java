package com.weixin.sdk.decoder;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.AbstractRecieved;
import com.weixin.sdk.message.LinkMessage;
import com.weixin.sdk.message.Receivable;

public class LinkMessageDecoder extends AbstractDecoder{

private final String EXPECTED_TYPE = "link";
    
    public static final String KEY_FOR_TITLE = "Title";
    public static final String KEY_FOR_DESC = "Description";
    public static final String KEY_FOR_URL = "Url";
    
    @Override
    public boolean support(Request request) {
        return isRequestMatchMessageType(request, EXPECTED_TYPE);
    }

    @Override
    void decodeMoreProperty(AbstractRecieved recieved, Request request) {
        LinkMessage message = (LinkMessage)recieved;
        message.setMessageId(request.get(KEY_FOR_MSG_ID));
        message.setUrl(request.get(KEY_FOR_URL));
        message.setTitle(request.get(KEY_FOR_TITLE));
        message.setDescription(request.get(KEY_FOR_DESC));
    }
    
    @Override
    Receivable newInstance() {
        return new LinkMessage();
    }
    
}
