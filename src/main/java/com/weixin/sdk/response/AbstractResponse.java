package com.weixin.sdk.response;

import java.util.Date;

import com.weixin.sdk.message.Receivable;

public abstract class AbstractResponse implements Response{

    private Integer createTime;
    private String fromUser;
    private String toUser;
    
    public AbstractResponse(){
        this.createTime = (int) (new Date().getTime() / 1000);
    }
    
    public abstract void appendCustomizeXMLContent(StringBuilder sb);
    
    public abstract String messageTypeIdentifer();
    
    public void initFromReceived(Receivable received){
        this.fromUser = received.toUser();
        this.toUser = received.fromUser();
    }
    
    public String toXML(){
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        
        sb.append(xmlString("FromUserName", this.fromUser));
        sb.append(xmlString("ToUserName", this.toUser));
        sb.append(xmlString("CreateTime", this.createTime));
        sb.append(xmlString("MsgType", this.messageTypeIdentifer()));
        
        appendCustomizeXMLContent(sb);
        
        sb.append("</xml>");
        return sb.toString();
    }
    
    protected String xmlString(String tag, Object content){
        return "<" + tag + ">" + content.toString() + "</" + tag + ">";
    }
    
    @Override
    public Integer getCreateTime() {
        return this.createTime;
    }

    @Override
    public String getFromUser() {
        return this.fromUser;
    }
    
    @Override
    public String getToUser() {
        return this.toUser;
    }
    
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }
    
    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }
    
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
}
