package com.weixin.sdk.message;

/**
 * 
 */
public class ClickEvent extends AbstractEvent implements Event{

    private String eventKey;
    
    @Override
    public EventType getEventType() {
        return EventType.CLICK;
    }
    
    public String getEventKey() {
        return eventKey;
    }
    
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

}
