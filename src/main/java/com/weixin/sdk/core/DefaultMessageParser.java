package com.weixin.sdk.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.weixin.sdk.Request;
import com.weixin.sdk.decoder.ClickEventDecoder;
import com.weixin.sdk.decoder.Decoder;
import com.weixin.sdk.decoder.ImageMessageDecoder;
import com.weixin.sdk.decoder.LinkMessageDecoder;
import com.weixin.sdk.decoder.LocationEventDecoder;
import com.weixin.sdk.decoder.LocationMessageDecoder;
import com.weixin.sdk.decoder.ScanEventDecoder;
import com.weixin.sdk.decoder.SubscribEventDecoder;
import com.weixin.sdk.decoder.TextMessageDecoder;
import com.weixin.sdk.decoder.UnsubscribEventDecoder;
import com.weixin.sdk.decoder.VideoMessageDecoder;
import com.weixin.sdk.decoder.ViewEventDecoder;
import com.weixin.sdk.decoder.VoiceMessageDecoder;
import com.weixin.sdk.message.Receivable;

public class DefaultMessageParser implements MessageParser{

    List<Decoder> decoders = new ArrayList<Decoder>();
    
    public DefaultMessageParser() {
        decoders.add(new TextMessageDecoder());
        decoders.add(new ImageMessageDecoder());
        decoders.add(new VoiceMessageDecoder());
        decoders.add(new VideoMessageDecoder());
        decoders.add(new LocationMessageDecoder());
        decoders.add(new LinkMessageDecoder());
        
        decoders.add(new SubscribEventDecoder());
        decoders.add(new ScanEventDecoder());
        decoders.add(new LocationEventDecoder());
        decoders.add(new UnsubscribEventDecoder());
        decoders.add(new ClickEventDecoder());
        decoders.add(new ViewEventDecoder());
    }
    
    @Override
    public Receivable parse(Request request) {
        Iterator<Decoder> it = this.decoders.iterator();
        while(it.hasNext()){
            Decoder decoder = it.next();
            if(decoder.support(request)){
                return decoder.decode(request);
            }
        }
        return null;
    }

}
