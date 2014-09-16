package com.weixin.sdk.decoder;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.AbstractRecieved;
import com.weixin.sdk.message.LocationMessage;
import com.weixin.sdk.message.Receivable;

public class LocationMessageDecoder extends AbstractDecoder{

    private final String EXPECTED_TYPE = "location";
    public static final String KEY_FOR_MEDIAID = "MediaId";
    
    public static final String KEY_FOR_Location_X = "Location_X";
    public static final String KEY_FOR_Location_Y = "Location_Y";
    public static final String KEY_FOR_SCALE = "Scale";
    public static final String KEY_FOR_LABEL = "Label";
    
    @Override
    public boolean support(Request request) {
        return isRequestMatchMessageType(request, EXPECTED_TYPE);
    }

    @Override
    void decodeMoreProperty(AbstractRecieved recieved, Request request) {
        LocationMessage message = (LocationMessage)recieved;
        message.setMessageId(request.get(KEY_FOR_MSG_ID));

        message.setLocationX(request.get(KEY_FOR_Location_X));
        message.setLocationY(request.get(KEY_FOR_Location_Y));
        message.setScale(Integer.valueOf(request.get(KEY_FOR_SCALE)));
        message.setLabel(request.get(KEY_FOR_LABEL));
    }
    
    @Override
    Receivable newInstance() {
        return new LocationMessage();
    }
    
}
