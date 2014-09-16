package com.weixin.sdk.core;

import com.weixin.sdk.Request;

/**
 * 
 * 解析微信传过来的字符串到xml模型
 */
public interface RequestParser {

    Request parse(String messageBody);
    
}
