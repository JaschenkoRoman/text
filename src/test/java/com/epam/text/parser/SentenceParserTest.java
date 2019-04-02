package com.epam.text.parser;

import com.epam.text.composite.Component;
import com.epam.text.composite.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SentenceParserTest {
    private static final String SENTENCE = "Java 5 2 + program.";

    @Test
    public void parseShouldReturnLexemeComponentWhenCorrectSentenceSupplied() {
        AbstractParser actualParser = new SentenceParser();
        Component sentence = actualParser.parse(SENTENCE);
        List<Component> lexemeList = sentence.getChildren();
        List<Component> expectedList = Arrays.asList(
                Lexeme.word("java"),
                Lexeme.expression("7"),
                Lexeme.word("program")
        );
        Assert.assertEquals(expectedList, lexemeList);
    }
}
