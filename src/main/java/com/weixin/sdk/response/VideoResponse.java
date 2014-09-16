package com.weixin.sdk.response;

public class VideoResponse extends AbstractResponse{

    private String mediaId;
    
    private String title;
    
    private String description;
    
    @Override
    public void appendCustomizeXMLContent(StringBuilder sb) {
        String mediaIdContent = xmlString("MediaId", this.mediaId);
        String titleContent = xmlString("Title", this.title);
        String descContent = xmlString("Description", this.description);
        
        sb.append(xmlString("Video", mediaIdContent + titleContent + descContent));
    }
    
    @Override
    public String messageTypeIdentifer() {
        return "video";
    }
    
    
    public String getMediaId() {
        return mediaId;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

}
