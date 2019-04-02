package com.epam.text.calculator.interpreter.expression;

import java.util.Deque;

public class MultiplyExpression implements Expression {
    @Override
    public void interpret(Deque<Integer> context) {
        Integer secondElement = context.pop();
        Integer firstElement = context.pop();
        context.push(firstElement * secondElement);
    }
}
