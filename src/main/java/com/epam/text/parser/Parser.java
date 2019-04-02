package com.epam.text.parser;

import com.epam.text.composite.Composite;

public interface Parser {
    Composite parse(String text);
}
