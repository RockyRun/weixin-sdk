package com.weixin.sdk;

import com.weixin.sdk.response.Response;

public interface Processor {

    boolean verify(String timestamp, String nonce, String signature, Environment env);
    
    Response process(String requestBody, Environment env);
    
}
