package com.weixin.sdk.core;

import java.util.HashMap;
import java.util.Map;

import com.weixin.sdk.Request;

public class RequestImpl implements Request{

    private Map<String, String> map;

    public RequestImpl(Map<String, String> map){
        this.map = new HashMap<String, String>(map);
    }
    
    @Override
    public boolean contains(String key) {
        return this.map.containsKey(key);
    }

    @Override
    public String get(String key) {
        return this.map.get(key);
    }

}
