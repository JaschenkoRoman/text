package com.epam.text.logic;

import com.epam.text.composite.Component;
import com.epam.text.composite.Composite;
import com.epam.text.composite.Lexeme;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractSorter implements Sorter {
    public Component sortLexemesInSentence(Component sentence, Comparator<Lexeme> comparator) {
        List<Component> children = sentence.getChildren();
        List<Lexeme> sortedLexemes = children
                .stream()
                .map(component -> (Lexeme) component)
                .sorted(comparator)
                .collect(Collectors.toList());
        Component sortedSentence = new Composite();
        sortedLexemes.forEach(sortedSentence::add);
        return sortedSentence;
    }
}
