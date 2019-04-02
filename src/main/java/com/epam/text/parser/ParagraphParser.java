package com.epam.text.parser;

import com.epam.text.composite.Composite;
import com.epam.text.composite.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    private static final String SENTENCE_PATTERN = "[^.!?]+(?:[.]{3}|[.!?])";

    @Override
    public Composite parse(String paragraph) {
        Matcher sentenceMatcher = Pattern.compile(SENTENCE_PATTERN).matcher(paragraph);
        Composite compositeParagraph = new Composite();
        Parser successor = getSuccessor();
        while (sentenceMatcher.find()) {
            Component sentenceComponent = successor.parse(sentenceMatcher.group());
            compositeParagraph.add(sentenceComponent);
        }
        return compositeParagraph;
    }

}
