package com.algorithms.recruitment.bolt;


public class TaxifyWordReverser {
    public char[] reverseWords(char [] input) throws Exception{
        if (input == null){
            throw new Exception("Input array is not initialized");
        }

        int newWordStratPos = -1;
        for (int index = 0; index < input.length; index++){
            if (input[index] == ' '){
                continue;
            }
            if (newWordStratPos == -1){
                newWordStratPos = index;
            }
            if (input[index+1] == ' ' || index +1 == input.length){
                for (int wordLeftIndex=newWordStratPos, wordRightndex=index; wordLeftIndex<wordRightndex; wordLeftIndex++, wordRightndex--){
                    char temp = input[wordLeftIndex];
                    input[wordLeftIndex] = input[wordRightndex];
                    input[wordRightndex] = temp;
                }
                newWordStratPos = -1;
            }
        }
        return input;
    }
}


