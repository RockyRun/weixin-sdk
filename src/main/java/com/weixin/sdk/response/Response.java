package com.weixin.sdk.response;

/**
 *
 * 被动响应微信请求之后的响应类，根据微信API需要转换为xml格式再发送出去
 *
 */
public interface Response {

    /**
     *  响应的发送者 
     */
    String getFromUser();
    
    /**
     *  响应的接收者 
     */
    String getToUser();
    
    /**
     *  响应的创建时间，以Linux的timestamp表示 
     */
    Integer getCreateTime();
    
    /**
     * 
     * 将想用转换为符合微信格式的xml字符串
     */
    String toXML();
    
}
