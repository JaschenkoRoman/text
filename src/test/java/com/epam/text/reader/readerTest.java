package com.epam.text.reader;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class readerTest {
    private static final String FILE_PATH = "src/test/resources/text.txt";
    private static final String WRONG_PATH = "incorrect";
    private static final String
            FILE_CONTENT = " It has survived not only five centuries," +
            " but also the leap into electronic typesetting, remaining essentially unchanged. " +
            "It was popularised 2 4 + 6 * 2 / 3 - with the release of Letraset sheets containing Lorem Ipsum passages," +
            " and more recently with desktop publishing software like aldus PageMaker including versions of Lorem Ipsum." +
            System.lineSeparator() +
            " It is a long established fact that a reader will be distracted by the readable content of a page" +
            " when looking at its layout. The point of using 22 8 + 6 * 5 -  Ipsum is that it has a more-or-less normal" +
            " distribution of letters, as opposed to using (Content here), content here," +
            "  making it look like readable English." +
            System.lineSeparator() +
            " It is a 2 4 + 6 * 2 / 3 - established fact that a reader will be of a page when looking at its layout." +
            System.lineSeparator() +
            " Bye.";
    private final Reader fileReader = new TextReader();

    @Test
    public void testReaderShouldReturnTextWhenCorrectFileSupplied() throws IOException {
        String readResult = fileReader.readText(FILE_PATH);
        Assert.assertEquals(readResult, FILE_CONTENT);
    }

    @Test(expected = IOException.class)
    public void testReaderShouldFailWhenIncorrectFileSupplied() throws IOException {
        fileReader.readText(WRONG_PATH);
    }
}
