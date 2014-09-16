package com.weixin.sdk.handler;

import com.weixin.sdk.Environment;
import com.weixin.sdk.message.ClickEvent;
import com.weixin.sdk.message.LocationEvent;
import com.weixin.sdk.message.ScanEvent;
import com.weixin.sdk.message.SubscribeEvent;
import com.weixin.sdk.message.UnsubscribeEvent;
import com.weixin.sdk.message.VerifyEvent;
import com.weixin.sdk.message.ViewEvent;
import com.weixin.sdk.response.EmptyResponse;
import com.weixin.sdk.response.Response;

public abstract class EventHanlderAdapapter extends AbstractEventMessageHandler{

    @Override
    public Response handleSubscribeEvent(SubscribeEvent event, Environment env) {
        return EmptyResponse.instance;
    }

    @Override
    public Response handleUnsubscribeEvent(UnsubscribeEvent event, Environment env) {
        return EmptyResponse.instance;
    }

    @Override
    public Response handleScanEvent(ScanEvent event, Environment env) {
        return EmptyResponse.instance;
    }

    @Override
    public Response handleLocationEvent(LocationEvent event, Environment env) {
        return EmptyResponse.instance;
    }

    @Override
    public Response handleClickEvent(ClickEvent event, Environment env) {
        return EmptyResponse.instance;
    }

    @Override
    public Response handleViewEvent(ViewEvent event, Environment env) {
        return EmptyResponse.instance;
    }
    
    @Override
    Response handleVerifyEvent(VerifyEvent eventMessage, Environment env) {
        return EmptyResponse.instance;
    }

}
