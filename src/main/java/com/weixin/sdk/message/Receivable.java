package com.weixin.sdk.message;

public interface Receivable {

    String fromUser();
    
    String toUser();
    
    Integer createTime();
    
    MessageType messageType();
    
}
