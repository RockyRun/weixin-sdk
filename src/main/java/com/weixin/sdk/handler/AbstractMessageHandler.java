package com.weixin.sdk.handler;

import com.weixin.sdk.Environment;
import com.weixin.sdk.message.ImageMessage;
import com.weixin.sdk.message.LinkMessage;
import com.weixin.sdk.message.LocationMessage;
import com.weixin.sdk.message.Message;
import com.weixin.sdk.message.MessageType;
import com.weixin.sdk.message.TextMessage;
import com.weixin.sdk.message.VideoMessage;
import com.weixin.sdk.message.VoiceMessage;
import com.weixin.sdk.response.EmptyResponse;
import com.weixin.sdk.response.Response;

import static com.weixin.sdk.message.MessageType.*;

public abstract class AbstractMessageHandler implements MessageHandler{

    abstract Response handleTextMessage(TextMessage message, Environment env);
    
    abstract Response handleImageMessage(ImageMessage message, Environment env);
    
    abstract Response handleLinkMessage(LinkMessage message, Environment env);
    
    abstract Response handleLocationMessage(LocationMessage message, Environment env);
    
    abstract Response handleVoiceMessage(VoiceMessage message, Environment env);
    
    abstract Response handleVideoMessage(VideoMessage message, Environment env);
    
    @Override
    public Response handleMessage(Message message, Environment env) {
        MessageType type = message.messageType();
        if (TEXT.equals(type)) {
            return handleTextMessage((TextMessage)message, env);
        } else if (IMAGE.equals(type)){
            return handleImageMessage((ImageMessage)message, env);
        } else if (LINK.equals(type)){
            return handleLinkMessage((LinkMessage)message, env);
        } else if (LOCATION.equals(type)){
            return handleLocationMessage((LocationMessage) message, env);
        } else if (VOICE.equals(type)){
            return handleVoiceMessage((VoiceMessage) message, env);
        } else if (VIDEO.equals(type)){
            return handleVideoMessage((VideoMessage) message, env);
        }
        return new EmptyResponse();
    }

}
