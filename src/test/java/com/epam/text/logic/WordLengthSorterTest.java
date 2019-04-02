package com.epam.text.logic;

import com.epam.text.composite.Component;
import com.epam.text.composite.Composite;
import com.epam.text.composite.Lexeme;
import org.junit.Assert;
import org.junit.Test;

public class WordLengthSorterTest {
    @Test
    public void sortShouldSortWordsByLengthWhenTextSupplied() {
        Component sentence = new Composite();
        sentence.add(Lexeme.word("today"));
        sentence.add(Lexeme.word("java"));
        sentence.add(Lexeme.word("program"));
        Component Paragraph = new Composite();
        Paragraph.add(sentence);
        Component text = new Composite();
        text.add(Paragraph);

        Component expectedSentence = new Composite();
        expectedSentence.add(Lexeme.word("java"));
        expectedSentence.add(Lexeme.word("today"));
        expectedSentence.add(Lexeme.word("program"));
        Component expectedParagraph = new Composite();
        expectedParagraph.add(expectedSentence);
        Component expected = new Composite();
        expected.add(expectedParagraph);


        Sorter sorter = new WordLengthSorter();
        Component actual = sorter.sort(text);

        Assert.assertEquals(expected, actual);
    }
}
