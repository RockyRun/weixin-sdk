package com.weixin.sdk.handler;

import static com.weixin.sdk.message.EventType.CLICK;
import static com.weixin.sdk.message.EventType.LOCATION;
import static com.weixin.sdk.message.EventType.SCAN;
import static com.weixin.sdk.message.EventType.SUBSCRIBE;
import static com.weixin.sdk.message.EventType.UNSUBSCRIBE;
import static com.weixin.sdk.message.EventType.VIEW;
import static com.weixin.sdk.message.EventType.VERIFY;

import com.weixin.sdk.Environment;
import com.weixin.sdk.message.ClickEvent;
import com.weixin.sdk.message.Event;
import com.weixin.sdk.message.EventType;
import com.weixin.sdk.message.LocationEvent;
import com.weixin.sdk.message.ScanEvent;
import com.weixin.sdk.message.SubscribeEvent;
import com.weixin.sdk.message.UnsubscribeEvent;
import com.weixin.sdk.message.VerifyEvent;
import com.weixin.sdk.message.ViewEvent;
import com.weixin.sdk.response.EmptyResponse;
import com.weixin.sdk.response.Response;

public abstract class AbstractEventMessageHandler implements EventHandler{

    abstract Response handleSubscribeEvent(SubscribeEvent eventMessage, Environment env);
    abstract Response handleUnsubscribeEvent(UnsubscribeEvent eventMessage, Environment env);
    abstract Response handleScanEvent(ScanEvent eventMessage, Environment env);
    abstract Response handleLocationEvent(LocationEvent eventMessage, Environment env);
    abstract Response handleClickEvent(ClickEvent eventMessage, Environment env);
    abstract Response handleViewEvent(ViewEvent eventMessage, Environment env);
    abstract Response handleVerifyEvent(VerifyEvent eventMessage, Environment env);
    
    @Override
    public Response handleEvent(Event eventMessage, Environment env) {
        EventType type = eventMessage.getEventType();
        if (SUBSCRIBE.equals(type)) {
            return handleSubscribeEvent((SubscribeEvent)eventMessage, env);
        } else if(UNSUBSCRIBE.equals(type)) {
            return handleUnsubscribeEvent((UnsubscribeEvent) eventMessage, env);
        } else if (SCAN.equals(type)) {
            return handleScanEvent((ScanEvent) eventMessage, env);
        } else if (LOCATION.equals(type)) {
            return handleLocationEvent((LocationEvent) eventMessage, env);
        } else if (VIEW.equals(type)) {
            return handleViewEvent((ViewEvent) eventMessage, env);
        } else if (CLICK.equals(type)) {
            return handleClickEvent((ClickEvent) eventMessage, env);
        } else if (VERIFY.equals(type)) {
            return handleVerifyEvent((VerifyEvent) eventMessage, env);
        }
        return EmptyResponse.instance;
    }

    

}
