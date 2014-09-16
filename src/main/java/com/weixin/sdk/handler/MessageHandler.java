package com.weixin.sdk.handler;

import com.weixin.sdk.Environment;
import com.weixin.sdk.message.Message;
import com.weixin.sdk.response.Response;

public interface MessageHandler {

    Response handleMessage(Message message, Environment env);
    
}
