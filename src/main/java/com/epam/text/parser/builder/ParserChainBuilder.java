package com.epam.text.parser.builder;

import com.epam.text.parser.*;


public class ParserChainBuilder implements ParserBuilder {
    @Override
    public Parser build() {
        AbstractParser sentenceParser = new SentenceParser();
        AbstractParser paragraphParser = new ParagraphParser();
        AbstractParser textParser = new TextParser();
        textParser.setSuccessor(paragraphParser);
        paragraphParser.setSuccessor(sentenceParser);
        return textParser;
    }
}
