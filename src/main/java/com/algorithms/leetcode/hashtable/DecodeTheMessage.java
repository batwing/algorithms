package com.algorithms.leetcode.hashtable;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DecodeTheMessage {
    public String decode(String key, String message) {
        if (key == null || key.length() == 0 || message == null || message.length() == 0)
            return "";

        String keyInLowerCase = key.toLowerCase();
        String messageInLowerCase = message.toLowerCase();
        Set<Character> keyUniqueLetters = new LinkedHashSet<Character>();
        for (int i=0; i<keyInLowerCase.length(); i++) {
            Character keyCharAt = keyInLowerCase.charAt(i);

            if (' ' == keyCharAt)
                continue;

            keyUniqueLetters.add(keyCharAt);
        }

        Map<Character, Character> substitutionTable = new LinkedHashMap<Character, Character>(keyUniqueLetters.size());
        Character alphabetLetter='a';
        for (Character encodedKey: keyUniqueLetters){
            substitutionTable.put(encodedKey, alphabetLetter++);
        }
        //edge case
        substitutionTable.put(' ',' ');

        StringBuilder result = new StringBuilder();

        for(char letter: messageInLowerCase.toCharArray()){
            result.append(substitutionTable.get(letter));
        }

        return result.toString();
    }
}
