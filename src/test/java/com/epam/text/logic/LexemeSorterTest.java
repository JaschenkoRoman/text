package com.epam.text.logic;

import com.epam.text.composite.Component;
import com.epam.text.composite.Composite;
import com.epam.text.composite.Lexeme;
import org.junit.Assert;
import org.junit.Test;

public class LexemeSorterTest {
    private static final char SYMBOL = 'j';

    @Test
    public void sortShouldSortLexemesWhenSentenceSupplied() {
        Component sentence = new Composite();
        sentence.add(Lexeme.word("java"));
        sentence.add(Lexeme.word("program"));
        sentence.add(Lexeme.word("javajava"));

        Component expected = new Composite();
        expected.add(Lexeme.word("program"));
        expected.add(Lexeme.word("java"));
        expected.add(Lexeme.word("javajava"));

        Sorter sorter = new LexemeSorter(SYMBOL);
        Component actual = sorter.sort(sentence);

        Assert.assertEquals(expected, actual);
    }
}
