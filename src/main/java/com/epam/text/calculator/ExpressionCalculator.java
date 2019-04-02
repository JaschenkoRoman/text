package com.epam.text.calculator;
import com.epam.text.calculator.interpreter.expression.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ExpressionCalculator {
    private static final String EXPRESSION_DELIMITER = " ";
    private Deque<Integer> context;
    private List<Expression> listExpression;

    private void parse(String expression) {
        context = new ArrayDeque<>();
        listExpression = new ArrayList<>();
        String[] expressionList = expression.split(EXPRESSION_DELIMITER);
        for (String expressionLexeme : expressionList) {
            char tmp = expressionLexeme.charAt(0);
            switch (tmp) {
                case '+': {
                    listExpression.add(new PlusExpression());
                    break;
                }
                case '-': {
                    listExpression.add(new MinusExpression());
                    break;
                }
                case '*': {
                    listExpression.add(new MultiplyExpression());
                    break;
                }
                case '/': {
                    listExpression.add(new DivideExpression());
                    break;
                }
                default: {
                    Integer number = Integer.parseInt(expressionLexeme);
                    listExpression.add(new NumberExpression(number));
                }
            }
        }
    }
    public Integer calculate(String expression) {
        parse(expression);
        for(Expression terminal: listExpression) {
            terminal.interpret(context);
        }
        return context.pop();
    }

}