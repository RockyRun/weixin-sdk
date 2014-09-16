package com.weixin.sdk.decoder;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.AbstractRecieved;
import com.weixin.sdk.message.Event;
import com.weixin.sdk.message.ViewEvent;

public class ViewEventDecoder extends AbstractEventDecoder{

    private final String EXPECTED_EVENT_TYPE =  "VIEW";
    public static final String KEY_FOR_EVENT_KEY = "EventKey";
    
    @Override
    public boolean support(Request request) {
        return isRequestAEvent(request) && isRequestMatchEventType(request, EXPECTED_EVENT_TYPE);
    }

    @Override
    void decodeMoreProperty(AbstractRecieved recieved, Request request) {
        ViewEvent event = (ViewEvent)recieved;
        event.setEventKey(request.get(KEY_FOR_EVENT_KEY));
    }
    
    @Override
    Event newInstance() {
        return new ViewEvent();
    }
    
}
