package com.weixin.sdk.decoder;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.AbstractRecieved;
import com.weixin.sdk.message.Event;
import com.weixin.sdk.message.UnsubscribeEvent;

public class UnsubscribEventDecoder extends AbstractEventDecoder{

    private final String EXPECTED_EVENT_TYPE =  "unsubscribe";
    
    @Override
    public boolean support(Request request) {
        return isRequestAEvent(request) && isRequestMatchEventType(request, EXPECTED_EVENT_TYPE);
    }

    @Override
    void decodeMoreProperty(AbstractRecieved recieved, Request request) {
        
    }
    
    @Override
    Event newInstance() {
        return new UnsubscribeEvent();
    }
    
}
