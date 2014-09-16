package com.weixin.sdk.handler;

import com.weixin.sdk.Environment;
import com.weixin.sdk.message.ImageMessage;
import com.weixin.sdk.message.LinkMessage;
import com.weixin.sdk.message.LocationMessage;
import com.weixin.sdk.message.TextMessage;
import com.weixin.sdk.message.VideoMessage;
import com.weixin.sdk.message.VoiceMessage;
import com.weixin.sdk.response.EmptyResponse;
import com.weixin.sdk.response.Response;

public abstract class MessageHandlerAdapter extends AbstractMessageHandler {

    @Override
    public Response handleTextMessage(TextMessage message, Environment env) {
        return EmptyResponse.instance;
    }

    @Override
    public Response handleImageMessage(ImageMessage message, Environment env) {
        return EmptyResponse.instance;
    }

    @Override
    public Response handleLinkMessage(LinkMessage message, Environment env) {
        return EmptyResponse.instance;
    }

    @Override
    public Response handleLocationMessage(LocationMessage message, Environment env) {
        return EmptyResponse.instance;
    }

    @Override
    public Response handleVoiceMessage(VoiceMessage message, Environment env) {
        return EmptyResponse.instance;
    }

    @Override
    public Response handleVideoMessage(VideoMessage message, Environment env) {
        return EmptyResponse.instance;
    }

}
