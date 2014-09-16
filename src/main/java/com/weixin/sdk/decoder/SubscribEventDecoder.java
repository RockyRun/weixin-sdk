package com.weixin.sdk.decoder;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.AbstractRecieved;
import com.weixin.sdk.message.Event;
import com.weixin.sdk.message.SubscribeEvent;

public class SubscribEventDecoder extends AbstractEventDecoder{

    private final String EXPECTED_EVENT_TYPE =  "subscribe";
    public static final String KEY_FOR_EVENT_KEY = "EventKey";
    public static final String KEY_FOR_EVENT_TICKET = "Ticket";
    
    @Override
    public boolean support(Request request) {
        return isRequestAEvent(request) && isRequestMatchEventType(request, EXPECTED_EVENT_TYPE);
    }

    @Override
    void decodeMoreProperty(AbstractRecieved recieved, Request request) {
        SubscribeEvent message = (SubscribeEvent)recieved;
        message.setEventKey(request.get(KEY_FOR_EVENT_KEY));
        message.setTicket(request.get(KEY_FOR_EVENT_TICKET));
    }
    
    @Override
    Event newInstance() {
        return new SubscribeEvent();
    }
    
}
