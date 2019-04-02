package com.epam.text.composite;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lexeme implements Component {
    private String value;
    private LexemeType lexemeType;


    public Lexeme(String value, LexemeType lexemeType) {
        this.value = value;
        this.lexemeType = lexemeType;
    }

    public static Component word(String value) {
        return new Lexeme(value, LexemeType.WORD);
    }

    public static Component expression(String value) {
        return new Lexeme(value, LexemeType.EXPRESSION);
    }

    public String getValue() {
        return value;
    }

    public LexemeType getLexemeType(){
        return lexemeType;
    }

    public void add(Component component) {

    }

    public List<Component> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lexeme lexeme = (Lexeme) o;
        return value.equals(lexeme.value) &&
                lexemeType == lexeme.lexemeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, lexemeType);
    }

    @Override
    public String toString() {
        return "Lexeme {" +
                "value = '" + value + '\'' +
                ", lexemeType = " + lexemeType +
                '}';
    }
}
