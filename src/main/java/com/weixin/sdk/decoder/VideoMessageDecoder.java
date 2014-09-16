package com.weixin.sdk.decoder;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.AbstractRecieved;
import com.weixin.sdk.message.VideoMessage;
import com.weixin.sdk.message.Receivable;

public class VideoMessageDecoder extends AbstractDecoder{

    private final String EXPECTED_TYPE = "video";
    public static final String KEY_FOR_THUMBMEDIAID = "ThumbMediaId";
    public static final String KEY_FOR_MEDIAID = "MediaId";
    
    @Override
    public boolean support(Request request) {
        return isRequestMatchMessageType(request, EXPECTED_TYPE);
    }

    @Override
    void decodeMoreProperty(AbstractRecieved recieved, Request request) {
        VideoMessage message = (VideoMessage)recieved;
        message.setMessageId(request.get(KEY_FOR_MSG_ID));
        message.setMediaId(request.get(KEY_FOR_MEDIAID));
        message.setThumbMediaId(request.get(KEY_FOR_THUMBMEDIAID));
    }
    
    @Override
    Receivable newInstance() {
        return new VideoMessage();
    }
    
}
