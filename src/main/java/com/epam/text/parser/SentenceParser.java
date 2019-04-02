package com.epam.text.parser;

import com.epam.text.calculator.ExpressionCalculator;
import com.epam.text.composite.Composite;
import com.epam.text.composite.Component;
import com.epam.text.composite.Lexeme;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {
    private static final String WORD_PATTERN = "[a-zA-Z,:;']+([.]{3}|[!?.])?";
    private static final String EXPRESSION_PATTERN = "[\\d]+[ \\d/*+-=]+[\\d/*+-=]+";
    private static final String LEXEME_PATTERN = "(" + WORD_PATTERN + ")|(" + EXPRESSION_PATTERN + ")";
    private ExpressionCalculator calculator = new ExpressionCalculator();
    @Override
    public Composite parse(String sentence) {
        Matcher lexemeMatcher = Pattern.compile(LEXEME_PATTERN).matcher(sentence);
        Composite sentenceComponent = new Composite();
        while (lexemeMatcher.find()) {
            String lexeme = lexemeMatcher.group();
            Component lexemeComponent = null;
            if (lexeme.matches(EXPRESSION_PATTERN)) {
                Integer expression = calculator.calculate(lexeme);
                lexemeComponent = Lexeme.expression(expression.toString());
            } else {
                String wordLexeme = lexeme.replaceAll("\\W", "").toLowerCase();
                if(!wordLexeme.matches("")) {
                    lexemeComponent = Lexeme.word(wordLexeme);
                }
            }
            if (lexemeComponent != null) {
                sentenceComponent.add(lexemeComponent);
            }
        }
        return sentenceComponent;
    }
}
