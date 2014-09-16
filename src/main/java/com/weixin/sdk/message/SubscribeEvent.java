package com.weixin.sdk.message;

/**
 * 
 * TODO 此事件还要包含通过扫描二维码进行关注的事件
 */
public class SubscribeEvent extends AbstractEvent implements Event{

    private String eventKey;
    
    private String ticket;
    
    @Override
    public EventType getEventType() {
        return EventType.SUBSCRIBE;
    }

    public String getEventKey() {
        return eventKey;
    }
    
    public String getTicket() {
        return ticket;
    }
    
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
    
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    
}
