package com.weixin.sdk.decoder;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.Event;


public abstract class AbstractEventDecoder extends AbstractDecoder{

    public final String EXPECTED_MESSAGE_TYPE = "event";
    public static final String KEY_FOR_EVENT_TYPE = "Event";
 
    protected boolean isRequestMatchEventType(Request request, String eventType){
        return eventType.equals(request.get(KEY_FOR_EVENT_TYPE));
    }
    
    protected boolean isRequestAEvent(Request request){
        return EXPECTED_MESSAGE_TYPE.equals(request.get(KEY_FOR_MSG_TYPE));
    }
    
    @Override
    abstract Event newInstance();
}
