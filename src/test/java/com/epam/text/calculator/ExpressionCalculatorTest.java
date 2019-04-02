package com.epam.text.calculator;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionCalculatorTest {
    private final ExpressionCalculator calculator = new ExpressionCalculator();
    @Test
    public void testPlusOperationShouldReturnFiveWhenTwoAndThreeSupplied(){
        String expression = "2 3 +";
        Integer actual = calculator.calculate(expression);
        Integer expected = 5;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testMinusOperationShouldReturnThreeWhenSevenAndFourSupplied(){
        String expression = "7 4 -";
        Integer actual = calculator.calculate(expression);
        Integer expected = 3;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testMultiplyOperationShouldReturnFifteenWhenThreeAndFiveSupplied(){
        String expression = "3 5 *";
        Integer actual = calculator.calculate(expression);
        Integer expected = 15;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testDivideOperationShouldReturnTwoWhenTenAndFiveSupplied(){
        String expression = "10 5 /";
        Integer actual = calculator.calculate(expression);
        Integer expected = 2;
        Assert.assertEquals(expected, actual);
    }
}
