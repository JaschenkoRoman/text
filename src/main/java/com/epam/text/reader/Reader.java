package com.epam.text.reader;

import java.io.IOException;

public interface Reader {
    String readText(String filePath) throws IOException;
}
