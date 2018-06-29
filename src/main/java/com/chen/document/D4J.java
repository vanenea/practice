package com.chen.document;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Iterator;
import java.util.List;

public class D4J {

    public static void main(String[] args) {
        //创建XML
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("utf-8");
        Element root = document.addElement("root");

        Element user = root.addElement("user");
        Element username = user.addElement("username").addText("chen");
        Element password = user.addElement("password").addText("yan");
        Element user1 = root.addElement("user");
        Element username1 = user1.addElement("username").addText("chen1");
        Element password1 = user1.addElement("password").addText("yan1");
        String XML = document.asXML();
        System.out.println(XML);


        //解析XML
        try {
            Document doc = DocumentHelper.parseText(XML);
            Element rootElement = doc.getRootElement();
            Iterator<Element> iterator = rootElement.elementIterator();
            System.out.println("------------iterator---------");
            while (iterator.hasNext()){
                Element next = iterator.next();
                System.out.println("next:"+next.getText());
                System.out.println(next.elementText("username"));
                System.out.println(next.element("password").getText());
            }

            System.out.println("---------list-------");
            List<Element> user2 = rootElement.elements("user");
            for (int i = 0; i < user2.size(); i++) {
                System.out.println(user2.get(i).elementText("username"));
                System.out.println(user2.get(i).elementText("password"));
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }
}
