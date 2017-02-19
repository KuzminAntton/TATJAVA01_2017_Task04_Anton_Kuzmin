package com.epam.task5.sax_parser;



import com.epam.task5.bean.Meal;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MenuSaxHandler extends DefaultHandler {
    private List<Meal> mealList = new ArrayList<Meal>();
    String mealCategory;
    private Meal meal;
    private StringBuilder text;

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setDocumentLocator(Locator locator) {

    }

    public void startDocument() {
        //System.out.println("Parsing started");
    }


    public void endDocument() {
        //System.out.println("Parsing ended");
    }


    public void startElement(String uri, String localeName, String qName, Attributes attributes) {

        text = new StringBuilder();
        if(qName.equals("cold-snacks") || qName.equals("hot-snacks") || qName.equals("breakfast")) {
            mealCategory = attributes.getValue("name");
        }
        if(qName.equals("element")) {
            meal = new Meal();
            meal.setId(Integer.parseInt(attributes.getValue("id")));
        }



    }

    public void characters(char[] buffer , int start, int length) {
        text.append(buffer,start,length);
    }

    public void endElement(String uri, String localeName, String qName) throws SAXException {

        if(qName.toUpperCase().equals("MENU:MENU")) {
            qName = "menu-menu";
        }

    MenuTagNameForSax tagName = MenuTagNameForSax.valueOf(qName.toUpperCase().replace("-","_"));
        switch (tagName) {
            case NAME:
                meal.setName(text.toString());
                break;
            case PRICE:
                meal.setPrice(Integer.parseInt(text.toString()));
                break;
            case DISCRIPTION:
                meal.setDiscription(text.toString());
                break;
            case PORTION:
                meal.setPortion(text.toString());
                break;
            case ELEMENT:
                meal.setCategory(mealCategory);
                mealList.add(meal);
                meal = null;
                break;



        }

    }
}
