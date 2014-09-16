package com.weixin.sdk.decoder;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.AbstractRecieved;
import com.weixin.sdk.message.Event;
import com.weixin.sdk.message.LocationEvent;

public class LocationEventDecoder extends AbstractEventDecoder{

    private final String EXPECTED_EVENT_TYPE =  "LOCATION";
    
    @Override
    public boolean support(Request request) {
        return isRequestAEvent(request) && isRequestMatchEventType(request, EXPECTED_EVENT_TYPE);
    }

    @Override
    void decodeMoreProperty(AbstractRecieved recieved, Request request) {
        LocationEvent message = (LocationEvent)recieved;
    }
    
    @Override
    Event newInstance() {
        return new LocationEvent();
    }
    
}
