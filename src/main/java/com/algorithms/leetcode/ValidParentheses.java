package com.algorithms.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {

        Map<Integer, Integer> allPossibleBracketPairs = Map.of(
                Integer.valueOf('('), Integer.valueOf(')'),
                Integer.valueOf('['), Integer.valueOf(']'),
                Integer.valueOf('{'), Integer.valueOf('}')
        );

        Set<Integer> openBrackets = allPossibleBracketPairs.keySet();
        Set<Integer> closingBrackets = new HashSet<>(allPossibleBracketPairs.values());

        Stack<Integer> bracketsStack = new Stack<>();
        Integer theLastOpeningBracketFromStackHead;

        for (char nextSymbol: s.toCharArray()){
            Integer nextSymbolAsInt = Integer.valueOf(nextSymbol);
            if (openBrackets.contains(nextSymbolAsInt)){
                bracketsStack.push(nextSymbolAsInt);
            }
            else if (closingBrackets.contains(nextSymbolAsInt) && !bracketsStack.empty()){
                theLastOpeningBracketFromStackHead = bracketsStack.pop();
                Integer expectedClosingBracket = allPossibleBracketPairs.get(theLastOpeningBracketFromStackHead);
                if (expectedClosingBracket != nextSymbolAsInt)
                    return false;
            }
            else
                return false;
        }

        return bracketsStack.empty();
    }
}
