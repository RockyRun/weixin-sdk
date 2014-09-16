package com.weixin.sdk.decoder;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.AbstractRecieved;
import com.weixin.sdk.message.Receivable;

public abstract class AbstractDecoder implements Decoder{

    public static final String KEY_FOR_TOUSER = "ToUserName";
    public static final String KEY_FOR_FROMUSER = "FromUserName";
    public static final String KEY_FOR_CREATTIME = "CreateTime";
    
    public static final String KEY_FOR_MSG_TYPE = "MsgType";
    public static final String KEY_FOR_MSG_ID = "MsgId"; 
    
    
    abstract Receivable newInstance();
    
    abstract void decodeMoreProperty(AbstractRecieved recieved,  Request request);
    
    @Override
    public Receivable decode(Request request) {
        if(this.support(request)){
            Receivable received = newInstance();
            if(received instanceof AbstractRecieved){
                AbstractRecieved message = (AbstractRecieved)received;
                message.setCreateTime(Integer.valueOf(request.get(KEY_FOR_CREATTIME)));
                message.setFromUser(request.get(KEY_FOR_FROMUSER));
                message.setToUser(request.get(KEY_FOR_TOUSER));
                
                decodeMoreProperty(message, request);
                
                return message;
            }
            
        }
        return null;
    }
    
    protected boolean isRequestMatchMessageType(Request request, String messageType){
        return messageType.equals(request.get(KEY_FOR_MSG_TYPE));
    }
 
}
