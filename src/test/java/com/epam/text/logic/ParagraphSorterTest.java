package com.epam.text.logic;

import com.epam.text.composite.Component;
import com.epam.text.composite.Composite;
import com.epam.text.composite.Lexeme;
import org.junit.Assert;
import org.junit.Test;

public class ParagraphSorterTest {
    @Test
    public void sortShouldSortParagraphsBySentencesWhenTextSupplied() {
        Component firstLexeme = Lexeme.word("java");
        Component secondLexeme = Lexeme.word("program");
        Component thirdLexeme = Lexeme.word("abc");
        Component firstSentence = new Composite();
        firstSentence.add(firstLexeme);
        Component secondSentence = new Composite();
        secondSentence.add(secondLexeme);
        Component thirdSentence = new Composite();
        thirdSentence.add(thirdLexeme);

        Component firstParagraph = new Composite();
        firstParagraph.add(firstSentence);
        firstParagraph.add(secondSentence);
        firstParagraph.add(thirdSentence);
        Component secondParagraph = new Composite();
        secondParagraph.add(thirdSentence);
        secondParagraph.add(firstSentence);
        Component text = new Composite();
        text.add(firstParagraph);
        text.add(secondParagraph);

        Sorter paragraphSorter = new ParagraphSorter();
        Component actual = paragraphSorter.sort(text);

        Component expected = new Composite();
        expected.add(secondParagraph);
        expected.add(firstParagraph);

        Assert.assertEquals(expected, actual);
    }
}
