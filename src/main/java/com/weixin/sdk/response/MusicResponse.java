package com.weixin.sdk.response;

public class MusicResponse extends AbstractResponse{

    private String title;
    
    private String description;
    
    private String musicUrl;
    
    private String hqMusicUrl;
    
    private String thumbMediaId;
    
    @Override
    public void appendCustomizeXMLContent(StringBuilder sb) {
        String thumbMediaId = xmlString("MediaId", this.thumbMediaId);
        
        String titleContent = xmlString("Title", this.title);
        String descContent = xmlString("Description", this.description);
        String musicUrlContent = xmlString("MusicUrl", this.musicUrl);
        String hqMusicUrlContent = xmlString("HQMusicUrl", this.hqMusicUrl);
        String content = thumbMediaId + titleContent + descContent + musicUrlContent + hqMusicUrlContent;
        
        sb.append(xmlString("Music", content));
    }
    
    @Override
    public String messageTypeIdentifer() {
        return "music";
    }
    
    
    public String getDescription() {
        return description;
    }
    
    public String getHqMusicUrl() {
        return hqMusicUrl;
    }
    
    public String getMusicUrl() {
        return musicUrl;
    }
    
    public String getThumbMediaId() {
        return thumbMediaId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }
    
    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }
    
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
}
