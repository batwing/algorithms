package com.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    @Test
    void isValidShouldReturnTrueWhenAmountOfOpenedBracketsIsEqualToClosedInBackwardOrder() {
        assertTrue(new ValidParentheses().isValid("{{[()]}}"));
    }

    @Test
    void isValidShouldReturnTrueWhenAllBracketPairsFollowOneAfterAnother() {
        assertTrue(new ValidParentheses().isValid("{}[]()"));
    }

    @Test
    void isValidShouldReturnFalseWhenAmountOfOpenedBracketsIsNotEqualToClosed() {
        assertFalse(new ValidParentheses().isValid("{{[()"));
    }

    @Test
    void isValidShouldReturnFalseWhenStringIncludesOnlyClosingBrackets() {
        assertFalse(new ValidParentheses().isValid(")]}}"));
    }

    @Test
    void isValidShouldReturnTrueWhenStringIsEmpty() {
        assertTrue(new ValidParentheses().isValid(""));
    }
}