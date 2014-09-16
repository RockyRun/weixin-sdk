package com.weixin.sdk.message;

/**
 * 
 */
public class LocationEvent extends AbstractEvent implements Event{

    
    private float latitude;
    private float longitude;
    private float precision;
    
    @Override
    public EventType getEventType() {
        return EventType.LOCATION;
    }
    
    public float getLatitude() {
        return latitude;
    }
    
    public float getLongitude() {
        return longitude;
    }
    
    public float getPrecision() {
        return precision;
    }
    
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    
    public void setPrecision(float precision) {
        this.precision = precision;
    }

}
