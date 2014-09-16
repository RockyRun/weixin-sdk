package com.weixin.sdk;

import org.json.JSONObject;

public class ResponseStatus {

    private boolean succeed;
    private int errorCode = 0;
    private String errorMessage;
    private JSONObject data;

    public ResponseStatus(boolean succeed) {
        this.succeed = succeed;
        this.errorMessage = "ok";
    }

    public ResponseStatus(int errorCode, String errorMessage) {
        this.succeed = false;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    
    public static ResponseStatus error(int errorCode, String errorMessage) {
        return new ResponseStatus(errorCode, errorMessage);
    }
    
    public static ResponseStatus succeed() {
        return new ResponseStatus(true);
    }
    
    public static ResponseStatus succeed(JSONObject data) {
        ResponseStatus rs = new ResponseStatus(true);
        rs.setData(data);
        return rs;
    }
    
    private void setData(JSONObject data) {
        this.data = data;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public int getErrorCode() {
        return errorCode;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public JSONObject getData() {
        return data;
    }

    @Override
    public String toString() {
        JSONObject data = (this.data != null) ? this.data : null;
        return String.format("{succeed : %s, errorCode : %s, errorMessage : %s, data : %s }", 
                this.succeed, this.errorCode, this.errorMessage, data);
    }
    
}
