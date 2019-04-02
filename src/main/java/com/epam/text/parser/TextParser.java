package com.epam.text.parser;

import com.epam.text.composite.Component;
import com.epam.text.composite.Composite;

public class TextParser extends AbstractParser {

    public Composite parse(String text) {
        String[] paragraphs = text.split("\n");
        Composite compositeText = new Composite();
        Parser successor = getSuccessor();
        for (String paragraph: paragraphs) {
           Component paragraphComponent = successor.parse(paragraph);
           compositeText.add(paragraphComponent);
        }
        return compositeText;
    }
}
