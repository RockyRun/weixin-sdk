package com.weixin.sdk.message;

/**
 * 
 */
public class ScanEvent extends AbstractEvent implements Event{

    private String eventKey;
    
    private String ticket;
    
    @Override
    public EventType getEventType() {
        return EventType.SCAN;
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
