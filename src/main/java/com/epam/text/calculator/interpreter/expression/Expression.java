package com.epam.text.calculator.interpreter.expression;

import java.util.Deque;

public interface Expression {
    void interpret(Deque<Integer> context);
}
