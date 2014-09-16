package com.weixin.sdk.decoder;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.AbstractRecieved;
import com.weixin.sdk.message.ImageMessage;
import com.weixin.sdk.message.Receivable;

public class ImageMessageDecoder extends AbstractDecoder{

    private final String EXPECTED_TYPE = "image";
    
    public static final String KEY_FOR_PICURL = "PicUrl";
    public static final String KEY_FOR_MEDIAID = "MediaId";
    
    @Override
    public boolean support(Request request) {
        return isRequestMatchMessageType(request, EXPECTED_TYPE);
    }

    @Override
    void decodeMoreProperty(AbstractRecieved recieved, Request request) {
        ImageMessage message = (ImageMessage)recieved;
        message.setMessageId(request.get(KEY_FOR_MSG_ID));
        message.setPicUrl(request.get(KEY_FOR_PICURL));
        message.setMediaId(request.get(KEY_FOR_MEDIAID));
    }
    
    @Override
    Receivable newInstance() {
        return new ImageMessage();
    }
    
}
