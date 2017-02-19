package com.epam.task5.sax_parser;


import com.epam.task5.bean.Meal;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


import java.io.IOException;
import java.util.List;

public class SaxMenuParser {
    public static void startParser(String resourceName) throws SAXException, IOException, jdk.internal.org.xml.sax.SAXException {
        XMLReader reader =  XMLReaderFactory.createXMLReader();
        MenuSaxHandler handler = new MenuSaxHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource(resourceName));

        List<Meal> mealsList = handler.getMealList();

        for(Meal meal : mealsList) {
            System.out.println(meal);
        }
    }
}
