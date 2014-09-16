package com.weixin.sdk.decoder;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.AbstractRecieved;
import com.weixin.sdk.message.VoiceMessage;
import com.weixin.sdk.message.Receivable;

public class VoiceMessageDecoder extends AbstractDecoder{

    private final String EXPECTED_TYPE = "voice";
    public static final String KEY_FOR_FORMAT = "PicUrl";
    public static final String KEY_FOR_MEDIAID = "MediaId";
    
    @Override
    public boolean support(Request request) {
        return isRequestMatchMessageType(request, EXPECTED_TYPE);
    }

    @Override
    void decodeMoreProperty(AbstractRecieved recieved, Request request) {
        VoiceMessage message = (VoiceMessage)recieved;
        message.setMessageId(request.get(KEY_FOR_MSG_ID));
        message.setMediaId(request.get(KEY_FOR_MEDIAID));
        message.setFormat(request.get(KEY_FOR_FORMAT));
    }
    
    @Override
    Receivable newInstance() {
        return new VoiceMessage();
    }
    
}
