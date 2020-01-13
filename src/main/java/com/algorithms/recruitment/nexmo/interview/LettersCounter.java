package com.algorithms.recruitment.nexmo.interview;

/*
Input: abbbaaaccccddd
Output: a3b3a4c3d
 */

public class LettersCounter {
    public String solution(String text){
        StringBuilder result = new StringBuilder("");

        if (text == null || "".equals(text))
            return "";

        char letter = text.charAt(0);
        int counter = 1;

        for (int i=1; i<text.length(); i++) {

            if (letter != text.charAt(i)){
                appendNextCounterLetter(counter, letter, result);
                letter = text.charAt(i);
                counter = 1;
            } else {
                letter = text.charAt(i);
                counter++;
            }

            if (i == text.length() - 1) {
                appendNextCounterLetter(counter, letter, result);
            }
        }

        return result.toString();
    }

    private void appendNextCounterLetter(int counter, char letter, StringBuilder strBuilder){
        strBuilder.append(counter == 1 ? "" : counter).append(letter);
    }
}
