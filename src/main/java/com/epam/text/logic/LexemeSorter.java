package com.epam.text.logic;

import com.epam.text.composite.Component;
import com.epam.text.composite.Lexeme;

import java.util.Comparator;

public class LexemeSorter extends AbstractSorter {
    private final char symbol;

    public LexemeSorter(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public Component sort(Component sentence) {
        Comparator<Lexeme> symbolEntryCountComparator = Comparator
                .comparing(this::countNumberOfEntries)
                .thenComparing(lexeme -> lexeme.getValue().toLowerCase());
        return sortLexemesInSentence(sentence, symbolEntryCountComparator);
    }

    private long countNumberOfEntries(Lexeme lexeme) {
        String value = lexeme.getValue();
        return value
                .chars()
                .map(character -> (char) character)
                .filter(character -> character == symbol)
                .count();
    }
}
