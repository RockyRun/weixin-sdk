package com.weixin.sdk.core;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.weixin.sdk.Request;

public class DefaultRequestParser implements RequestParser {

    @Override
    public Request parse(String messageBody) {
        Map<String, String> map = mapFromXmlString(messageBody);
        return new RequestImpl(map);
    }
    
    private Map<String, String> mapFromXmlString(String content){
        Map<String, String> map = new HashMap<String, String>();
        
        DocumentBuilder db;
        try {
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(content));

            Document doc = db.parse(is);
            

            Element docEl = doc.getDocumentElement();       
            Node childNode = docEl.getFirstChild();
            while( childNode !=null ){          
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {         
                    Element childElement = (Element) childNode;
                    map.put(childElement.getTagName(), childElement.getTextContent());
                }       
                childNode = childNode.getNextSibling();         
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return map;
    }


}
