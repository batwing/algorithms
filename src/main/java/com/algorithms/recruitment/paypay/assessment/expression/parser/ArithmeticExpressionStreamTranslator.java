package com.algorithms.recruitment.paypay.assessment.expression.parser;

import java.util.*;
import java.util.stream.Stream;

public class ArithmeticExpressionStreamTranslator {

    private LinkedList<Token> recalculationStack;
    private LinkedList<Token> tokenStack;

    private static HashSet<Character> POSSIBLE_OPERANDS = new HashSet(Arrays.asList("*", "+", "-", "/"));

    private enum TokenType {
        OPERATOR,
        OPERAND,
        INTERMEDIATE_RESULT
    }

    public class Token {
        private String value;
        private TokenType type;
    }

    public Stream<String> process(Stream<Character> inputStream){
        return Stream.empty();
    }


}
