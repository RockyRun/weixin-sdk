package com.weixin.sdk.decoder;

import com.weixin.sdk.Request;
import com.weixin.sdk.message.Receivable;

public interface Decoder {

    boolean support(Request request);

    Receivable decode(Request request);

}
