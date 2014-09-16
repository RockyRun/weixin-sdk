package com.weixin.sdk.message;

public class UnsubscribeEvent extends AbstractEvent implements Event{

    @Override
    public EventType getEventType() {
        return EventType.UNSUBSCRIBE;
    }

}
