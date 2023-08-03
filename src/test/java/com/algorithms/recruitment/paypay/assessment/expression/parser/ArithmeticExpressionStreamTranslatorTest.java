package com.algorithms.recruitment.paypay.assessment.expression.parser;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

public class ArithmeticExpressionStreamTranslatorTest {
    @Test
    public void parseShouldReturnErrorWhenIllegalOperandProvided() {
        Stream<String> output = new ArithmeticExpressionStreamTranslator()
                .process(
                        "11*2?1+3?*7?++879?".chars().mapToObj(c -> (char)c)
                );
        String result = output.collect(Collectors.joining(","));
        assertEquals("22,234,252,ERROR", result);
    }

    @Test
    public void parseShouldCalculate1SimpleExpressionsWhenNoOtherExpressionsPresented() {
        Stream<String> output = new ArithmeticExpressionStreamTranslator()
                .process(
                        "11*2".chars().mapToObj(c -> (char)c)
                );
        String result = output.collect(Collectors.joining(","));
        assertEquals("22", result);
    }

    @Test
    public void parseShouldCalculate2ExpressionsWhenAllLeksemAreCorrect() {
        Stream<String> output = new ArithmeticExpressionStreamTranslator()
                .process(
                        "11*2?1+3?".chars().mapToObj(c -> (char)c)
                );
        String result = output.collect(Collectors.joining(","));
        assertEquals("22,234", result);
    }

    @Test
    public void parseShouldCalculateWhenOneOfExpStartsFromOperation() {
        Stream<String> output = new ArithmeticExpressionStreamTranslator()
                .process(
                        "11*2?1+3?*7?".chars().mapToObj(c -> (char)c)
                );
        String result = output.collect(Collectors.joining(","));
        assertEquals("22,234,252", result);
    }
}
