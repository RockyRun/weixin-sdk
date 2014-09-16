package com.weixin.sdk.response;

public class VoiceResponse extends AbstractResponse{

    private String mediaId;
    
    @Override
    public void appendCustomizeXMLContent(StringBuilder sb) {
        String mediaIdContent = xmlString("MediaId", this.mediaId);
        sb.append(xmlString("Voice", mediaIdContent));
    }
    
    @Override
    public String messageTypeIdentifer() {
        return "voice";
    }
    
    public String getMediaId() {
        return mediaId;
    }
    
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

}
