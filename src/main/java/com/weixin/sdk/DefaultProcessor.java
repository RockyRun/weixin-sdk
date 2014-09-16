package com.weixin.sdk;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.weixin.sdk.core.DefaultMessageParser;
import com.weixin.sdk.core.DefaultRequestParser;
import com.weixin.sdk.core.MessageParser;
import com.weixin.sdk.core.RequestParser;
import com.weixin.sdk.handler.EventHandler;
import com.weixin.sdk.handler.MessageHandler;
import com.weixin.sdk.message.Event;
import com.weixin.sdk.message.Message;
import com.weixin.sdk.message.Receivable;
import com.weixin.sdk.response.EmptyResponse;
import com.weixin.sdk.response.Response;
import com.weixin.sdk.util.EncoderHandler;

/**
 * 专门用来处理被动消息的类，依赖于 {@link AppSpecificProvider} 
 *
 */
public class DefaultProcessor implements Processor{

    private MessageHandler messageHandler;
    private EventHandler eventMessageHandler;
    private AppSpecificProvider appSpecificProvider;
    
    private boolean needVerify = true;
    
    private MessageParser messageParser = new DefaultMessageParser();
    private RequestParser requestParser = new DefaultRequestParser();
    
    public DefaultProcessor(){
        this(null, null);
    }
    
    public DefaultProcessor(MessageHandler messageHandler){
        this(messageHandler, null);
    }
    
    public DefaultProcessor(MessageHandler messageHandler, EventHandler eventMessageHandler) {
        this.messageHandler = messageHandler;
        this.eventMessageHandler = eventMessageHandler;
        this.appSpecificProvider = new FileBasedAppSpecificProvider();
    }

    @Override
    public boolean verify(String timestamp, String nonce, String signature, Environment env){
        
        if(!needVerify){ return true; }
        
        if(this.appSpecificProvider != null){
            String token = this.appSpecificProvider.getApp(env).getToken();
            return doVeiryfy(signature, token, timestamp, nonce);
        } else {
            throw new RuntimeException("Process need verify but without a AppSpecificProvider");
        }
    }

    /**
     * 
     * 验证步骤： <br /><br />
     * 
     *  1. 将token、timestamp、nonce三个参数进行字典序排序。 <br /><br />
     *  2. 将三个参数字符串拼接成一个字符串进行sha1加密。  <br /><br />
     *  3. 开发者获得加密后的字符串可与signature对比，检查消息的合法性。 <br /><br />
     * 
     * 
     * @param signature
     * @param token
     * @param timestamp
     * @param nonce
     * @return
     */
    private boolean doVeiryfy(String signature, String token, String timestamp, String nonce) {
        List<String> strings = Arrays.asList(token, timestamp, nonce);
        Collections.sort(strings);
        String joined = strings.get(0)+strings.get(1)+strings.get(2);
        String encoded = EncoderHandler.encodeAsSHA1(joined);
        return signature.equals(encoded);
    }
    
    /**
     * <ol>
     *   <li> 获取微信传过来的XML字符串 </li>
     *   <li> 将XML字符串解析成message对象 </li>
     *   <li> 使用message handler处理message，获取Response结果 </li>
     *     <ol>
     *       <li> 如果message是个普通消息，则调用用户自定义的MessageHandler处理消息 </li>
     *       <li> 如果message是个事件消息，则调用用户自定义的EventMessageHandler处理事件 </li>
     *     </ol>
     *   <li> 将用户处理完的Response返回，用户根据需要自己转化为XML字符串输出 </li>
     * </ol>
     */
    @Override
    public Response process(String requestBody, Environment env){
        Request request = requestParser.parse(requestBody);
        Receivable message = messageParser.parse(request);
        Response response = EmptyResponse.instance;
        if(message instanceof Event){
            response = this.eventMessageHandler.handleEvent((Event)message, env);
        }else if(message instanceof Message) {
            response = this.messageHandler.handleMessage((Message)message, env);
        }
        return response;
    }

    public void setNeedVerify(boolean needVerify) {
        this.needVerify = needVerify;
    }
    
    public void setAppSpecificProvider(AppSpecificProvider appSpecificProvider) {
        this.appSpecificProvider = appSpecificProvider;
    }
    
    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }
    
    public void setEventMessageHandler(EventHandler eventMessageHandler) {
        this.eventMessageHandler = eventMessageHandler;
    }
}
