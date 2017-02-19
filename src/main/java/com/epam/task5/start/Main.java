package com.epam.task5.start;

import com.epam.task5.dom_parser.DOMMenuParser;
import com.epam.task5.sax_parser.SaxMenuParser;
import com.epam.task5.stax_parser.StaxMenuParser;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws SAXException, IOException, jdk.internal.org.xml.sax.SAXException {

        String resourceName = "menuu.xml";


//        System.out.println("SAX Parser");
//        SaxMenuParser.startParser(resourceName);
//
//        System.out.println("Stax Parser");
//        StaxMenuParser.startParser(resourceName);

        System.out.println("DOM parser");
        DOMMenuParser.startParser(resourceName);

    }
}
