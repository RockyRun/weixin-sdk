package com.weixin.sdk.handler;

import com.weixin.sdk.Environment;
import com.weixin.sdk.message.Event;
import com.weixin.sdk.response.Response;

public interface EventHandler {
    
    Response handleEvent(Event event, Environment env);

}
