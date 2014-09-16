package com.weixin.sdk.response;

import org.junit.Test;

import com.weixin.sdk.custom.ArticlesCustomMessage;

public class TextResponseTest {

    @Test
    public void testA(){
        TextResponse tr = new TextResponse();
        tr.setFromUser("Tom");
        tr.setToUser("Jerry");
        tr.setCreateTime(123124414);
        tr.setContent("This is a test text");
//        System.out.println(tr.toXML());
//        System.out.println(tr.toJson());
        System.out.println(tr.toJson2());
    }
    
    @Test
    public void testImageResponse(){
        ImageResponse ir = new ImageResponse();
        ir.setFromUser("Tom");
        ir.setToUser("Jerry");
        ir.setCreateTime(123124414);
        ir.setMediaId("2137148adsf87hakdsfh");
//        System.out.println(ir.toXML());
    }
    
        
    
    @Test
    public void testArticleResponse(){
        ArticlesResponse ar = new ArticlesResponse();
        ar.setFromUser("Tom");
        ar.setToUser("Jerry");
        ar.setCreateTime(123124414);
        
        ArticleItem item = new ArticleItem();
        item.setDescription("item 1 desc");
        item.setTitle("item 1 title");
        item.setUrl("item 1 url");
        item.setPicUrl("item 1 pic url");
        
        ar.addArticle(item);
        
        ArticleItem item2 = new ArticleItem();
        item2.setDescription("item 2 desc");
        item2.setTitle("item 2 title");
        item2.setUrl("item 2 url");
        item2.setPicUrl("item 2 pic url");
        
        ar.addArticle(item2);
        
//        System.out.println(ar.toXML());
        
        ArticlesCustomMessage acm = new ArticlesCustomMessage();
        acm.setToUser("jerry");
        acm.addArticle(item);
        acm.addArticle(item2);
        
        System.out.println(acm.toJson());
        
    }
    
}
