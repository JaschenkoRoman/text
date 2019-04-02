package com.epam.text.parser;

import com.epam.text.composite.Component;
import com.epam.text.composite.Composite;
import com.epam.text.composite.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class TextParserTest {
    private static final String TEXT = "java program \n" + "abc def \n" + "good.";

    @Test
    public void testShouldReturnParagraphCompositeWhenCorrectTextSupplied() {
        AbstractParser abstractParser = mock(AbstractParser.class);

        Composite firstParagraph = new Composite();
        firstParagraph.add(Lexeme.word("java"));
        firstParagraph.add(Lexeme.word("program"));
        when(abstractParser.parse("java program ")).thenReturn(firstParagraph);

        Composite secondParagraph = new Composite();
        secondParagraph.add(Lexeme.word("abc"));
        secondParagraph.add(Lexeme.word("def"));
        when(abstractParser.parse("abc def ")).thenReturn(secondParagraph);

        Composite thirdParagraph = new Composite();
        thirdParagraph.add(Lexeme.word("good"));
        when(abstractParser.parse("good.")).thenReturn(thirdParagraph);

        AbstractParser actualTextParser = new TextParser();
        actualTextParser.setSuccessor(abstractParser);
        Component paragraph = actualTextParser.parse(TEXT);
        List<Component> sentenceList = paragraph.getChildren();

        List<Component> expectedList = Arrays.asList(
                firstParagraph,
                secondParagraph,
                thirdParagraph
        );

        Assert.assertEquals(sentenceList, expectedList);
        verify(abstractParser, times(expectedList.size())).parse(anyString());
        verifyNoMoreInteractions(abstractParser);
    }

}
