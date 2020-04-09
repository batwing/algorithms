package com.algorithms.stack;

import static javax.swing.UIManager.put;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/***************************************************************
 *
 * Check if the sequence of parenthesises in a string is correct
 *
 * Test1
 * in: {([])}
 * out: true
 *
 * Test2
 * in: abc{)(
 * out: false
 *
 * Test3
 * in: )(
 * out: false
 *
 * ************************************************************/

public class BracketsValidator {

  private static final Set<String> openBrackets = Collections.unmodifiableSet(new HashSet(Arrays.asList("(", "{", "[")));
  private static final Map<String, String> pairBrackets;

  static {
    HashMap<String, String> mutablePairBracketsMap = new HashMap<>(3);
    mutablePairBracketsMap.put(")", "(");
    mutablePairBracketsMap.put("}", "{");
    mutablePairBracketsMap.put("]", "[");
    pairBrackets = Collections.unmodifiableMap(mutablePairBracketsMap);
  }

  private LinkedList<String> stackOfBrackets = new LinkedList<>();

  public boolean isBracketsSeqValid(String str){
    for(String symbol: str.split("")) {
      if (openBrackets.contains(symbol)) {
        stackOfBrackets.add(symbol);
      } else {
        String openBracket = pairBrackets.get(symbol);
        if (openBracket != null
            && (stackOfBrackets.isEmpty() || !openBracket.equals(stackOfBrackets.removeLast()))
        ){
          return false;
        }
      }
    }

    return stackOfBrackets.isEmpty();
  }
}
