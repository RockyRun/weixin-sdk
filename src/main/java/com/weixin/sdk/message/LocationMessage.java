package com.weixin.sdk.message;

public class LocationMessage extends AbstractMessage{
    
    private String locationX;
    private String locationY;
    private String label;
    private Integer scale;
    
    @Override
    public MessageType messageType() {
        return MessageType.LOCATION;
    }
    
    public String getLabel() {
        return label;
    }
    
    public String getLocationX() {
        return locationX;
    }
    
    public String getLocationY() {
        return locationY;
    }
    
    public Integer getScale() {
        return scale;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    
    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }
    
    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }
    
    public void setScale(Integer scale) {
        this.scale = scale;
    }
    
    
    
}
