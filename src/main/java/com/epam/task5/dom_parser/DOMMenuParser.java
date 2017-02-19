package com.epam.task5.dom_parser;


import com.epam.task5.bean.Meal;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMMenuParser {

    public static void startParser(String resourceName) throws IOException, SAXException {

        DOMParser parser = new DOMParser();
        parser.parse(resourceName);
        Document document = parser.getDocument();

        Element root = document.getDocumentElement();

        List<Meal> menu = new ArrayList<>();
        NodeList mealNodes = root.getElementsByTagName("element");
        Meal meal = null;
        for(int i = 0; i < mealNodes.getLength(); i++) {
            meal = new Meal();
            Element mealElement = (Element) mealNodes.item(i);

            meal.setId(Integer.parseInt(mealElement.getAttribute("id")));
            meal.setName(getSingleChild(mealElement,"name").getTextContent().trim());
            meal.setDiscription(getSingleChild(mealElement,"discription").getTextContent().trim());
            meal.setPortion(getSingleChild(mealElement,"portion").getTextContent().trim());
            meal.setPrice(Integer.parseInt(getSingleChild(mealElement,"price").getTextContent().trim()));
            menu.add(meal);


        }

        for (Meal m : menu) {
            System.out.println(m);
        }



    }

    private static Element getSingleChild(Element element, String childName) {
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }

}
