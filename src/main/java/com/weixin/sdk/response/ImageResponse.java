package com.weixin.sdk.response;

public class ImageResponse extends AbstractResponse{

    private String mediaId;
    
    public ImageResponse() {
        this(null);
    }
    
    public ImageResponse(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public void appendCustomizeXMLContent(StringBuilder sb) {
        String mediaIdContent = xmlString("MediaId", this.mediaId);
        sb.append(xmlString("Image", mediaIdContent));
    }

    @Override
    public String messageTypeIdentifer() {
        return "image";
    }
    
    public String getMediaId() {
        return mediaId;
    }
    
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
    
}
