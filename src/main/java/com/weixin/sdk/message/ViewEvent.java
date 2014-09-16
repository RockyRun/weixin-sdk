package com.weixin.sdk.message;

/**
 * 
 */
public class ViewEvent extends AbstractEvent implements Event{

    private String eventKey;
    
    @Override
    public EventType getEventType() {
        return EventType.VIEW;
    }

    public String getEventKey() {
        return eventKey;
    }
    
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
