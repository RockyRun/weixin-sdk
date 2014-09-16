package com.weixin.sdk.response;

import java.util.ArrayList;
import java.util.List;

public class ArticlesResponse extends AbstractResponse{

    private List<ArticleItem> articles = new ArrayList<ArticleItem>();
    
    public void addArticle(ArticleItem item){
        this.articles.add(item);
    }
    
    @Override
    public void appendCustomizeXMLContent(StringBuilder sb) {
        sb.append(xmlString("ArticleCount", this.getArticleCount()));
        
        StringBuilder itemsBuilder = new StringBuilder();
        for(ArticleItem item : this.articles){
            itemsBuilder.append(item.toXML());
        }
        sb.append(xmlString("Articles", itemsBuilder.toString()));
    }
    
    @Override
    public String messageTypeIdentifer() {
        return "news";
    }
    
    public int getArticleCount(){
        return this.articles.size();
    }
    
}
