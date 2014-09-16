package com.weixin.sdk.core;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.Receivable;

/**
 * 解析微信穿过来的xml文档至对应的消息类上去 
 *
 */
public interface MessageParser {

    Receivable parse(Request request); 
    
}
