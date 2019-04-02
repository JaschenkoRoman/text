package com.epam.text.reader;

import java.io.*;

public class TextReader implements Reader  {
    @Override
    public String readText(String filePath) throws IOException {
        String text;
        FileInputStream in = new FileInputStream(filePath);
        byte[] buffer = new byte[in.available()];
        in.read(buffer);
        text = new String(buffer);
        in.close();
        return text;
    }
}
