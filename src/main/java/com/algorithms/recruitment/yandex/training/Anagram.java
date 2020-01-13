package com.algorithms.recruitment.yandex.training;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Anagram {
    private String str1;
    private String str2;

    public Boolean isAnagramUsingMapOlinear() throws Exception {//2*O(N*logN)+O(N)
        HashMap<Character, Integer> charCounters = new HashMap<>();

        if (str1 == null || str2 == null){
            throw new Exception("One of arguments is not initialized...");
        }

        if (str1.length() != str2.length())
            return false;

        for (char currentChar : str1.toCharArray()){
            Integer currentCharCounter = charCounters.get(currentChar);
            if (currentCharCounter == null) {
                charCounters.put(currentChar, 1);
            }
            else {
                charCounters.put(currentChar, currentCharCounter++);
            }
        }

        for (char currentChar : str2.toCharArray()){
            Integer currentCharCounter = charCounters.get(currentChar);
            if (currentCharCounter == null || currentCharCounter <= 0) {
                return false;
            }
            else if (currentCharCounter == 1) {
                charCounters.remove(currentChar);
            }
            else {
                charCounters.put(currentChar, currentCharCounter-- );
            }

        }

        return charCounters.size() == 0;
    }

    public Boolean isAnagramUsingArrayOlinear() throws Exception {//2*O(N*logN)+O(N)
        if (str1 == null || str2 == null){
            throw new Exception("One of arguments is not initialized...");
        }

        if (str1.length() != str2.length())
            return false;

        int[] charCounts = new int[128];//Assumption of only ASCII not exended

        for (char elem1 :str1.toCharArray()){
            if (elem1 > 'z' || elem1 < 'a'){
                throw new Exception("One of characters is out of range");
            }
            charCounts[elem1]++;
        }

        for (char elem2: str2.toCharArray()){
            if (--charCounts[elem2] < 0){
                return false;
            }
        }

        return true;
    }

    public Boolean isAnagramOLog(){//2*O(N*logN)+O(N)
        return getSortedString(str1).equals(getSortedString(str2));
    }

    private String getSortedString(String str){//O(N*logN)
        return Arrays.stream(str.split(""))//O(N)
                .sorted((String o1, String o2) -> o1.compareTo(o2))//O(N*logN)
                .collect(Collectors.joining(""));//O(N)
    }
    public static void main(String args[]){
        String test = "test".concat("test2");
    }
}
