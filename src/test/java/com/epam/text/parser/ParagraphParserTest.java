package com.epam.text.parser;

import com.epam.text.composite.Component;
import com.epam.text.composite.Composite;
import com.epam.text.composite.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ParagraphParserTest {
    private static final String PARAGRAPH = "Java program." + "Abc def.";
    @Test
    public void testShouldReturnSentenceCompositeWhenCorrectParagraphSupplied(){
        AbstractParser abstractParser = mock(AbstractParser.class);
        Composite firstSentence = new Composite();
        firstSentence.add(Lexeme.word("java"));
        firstSentence.add(Lexeme.word("program"));
        when(abstractParser.parse("Java program.")).thenReturn(firstSentence);

        Composite secondSentence = new Composite();
        secondSentence.add(Lexeme.word("abc"));
        secondSentence.add(Lexeme.word("def"));
        when(abstractParser.parse("Abc def.")).thenReturn(secondSentence);

        AbstractParser actualParser = new ParagraphParser();
        actualParser.setSuccessor(abstractParser);
        Component paragraph = actualParser.parse(PARAGRAPH);
        List<Component> sentenceList = paragraph.getChildren();

        List<Component> expectedList = Arrays.asList(
                firstSentence,
                secondSentence
        );

        Assert.assertEquals(expectedList, sentenceList);
        verify(abstractParser, times(expectedList.size())).parse(anyString());
        verifyNoMoreInteractions(abstractParser);
    }
}
