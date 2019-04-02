package com.epam.text.logic;

import com.epam.text.composite.Component;
import com.epam.text.composite.Composite;
import com.epam.text.composite.Lexeme;

import java.util.Comparator;
import java.util.List;

public class WordLengthSorter extends AbstractSorter {
    private static final Comparator<Lexeme>
            COMPARATOR = Comparator.comparing(lexeme -> lexeme.getValue().length());

    @Override
    public Component sort(Component text) {
        Component sortedText = new Composite();
        List<Component> paragraphs = text.getChildren();
        for (Component paragraph : paragraphs) {
            Component sortedParagraph = sortSentences(paragraph);
            sortedText.add(sortedParagraph);
        }
        return sortedText;
    }

    private Component sortSentences(Component paragraph) {
        List<Component> sentences = paragraph.getChildren();
        Component sortedParagraph = new Composite();
        for (Component sentence : sentences) {
            Component sortedSentence = sortLexemesInSentence(sentence, COMPARATOR);
            sortedParagraph.add(sortedSentence);
        }
        return sortedParagraph;
    }

}
