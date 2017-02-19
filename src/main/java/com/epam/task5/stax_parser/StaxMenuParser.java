package com.epam.task5.stax_parser;


import com.epam.task5.bean.Meal;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StaxMenuParser {
    public static void startParser(String resourceName) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();

        try {
            InputStream input = new FileInputStream(resourceName);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            List<Meal> menu = process(reader);
            for (Meal meal : menu) {
                System.out.println(meal);
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

    }

    private static List<Meal> process(XMLStreamReader reader) throws XMLStreamException {

        List<Meal> menu = new ArrayList<>();
        Meal meal = null;
        MenuTagNameForStax elementName = null;
        String mealCategory = "";

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = MenuTagNameForStax.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case ELEMENT:

                            meal = new Meal();
                            Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                            meal.setId(id);
                            break;

                        case COLD_SNACKS:
                            mealCategory = reader.getAttributeValue(null,"name");
                            break;

                        case HOT_SNACKS:
                            mealCategory = reader.getAttributeValue(null,"name");
                            break;

                        case BREAKFAST:
                            mealCategory = reader.getAttributeValue(null,"name");
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case NAME:
                            meal.setName(text);
                            break;
                        case PRICE:
                            meal.setPrice(Integer.parseInt(text));
                            break;
                        case DISCRIPTION:
                            meal.setDiscription(text);
                            break;
                        case PORTION:
                            meal.setPortion(text);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = MenuTagNameForStax.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case ELEMENT:
                            meal.setCategory(mealCategory);
                            menu.add(meal);
                    }
            }

        }


        return menu;
    }
}

