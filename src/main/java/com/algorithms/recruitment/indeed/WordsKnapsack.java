package com.algorithms.recruitment.indeed;

import java.util.ArrayList;
import java.util.List;

public class WordsKnapsack {

        public static void main(String[] argv) {
            WordsKnapsack solution = new WordsKnapsack();
            String[] lines = {"The day began as still as the","night abruptly lighted with","brilliant flame"};
            int testReflowWidth1 = 24;
            int testReflowWidth2 = 26;
            int testReflowWidth3 = 40;
        }

        public void printSolution(List<String> list){
            list.forEach(x -> System.out.println(x));
        }

        public List<String> solution(String[] words, int maxWordSize){
            List<String> result = new ArrayList<>();
            StringBuilder strBuilder = new StringBuilder();

            for (int i=0; i<= words.length-1; i++) {
                strBuilder.append(words[i]);

                if (strBuilder.length() <= maxWordSize){

                    int currentPlusNextSize = (i==words.length-1)
                            ? strBuilder.length()
                            : strBuilder.length() + words[i+1].length() + 1;//1 for space

                    if (currentPlusNextSize > maxWordSize || i==words.length-1) {
                        result.add(strBuilder.toString());
                        strBuilder.setLength(0);
                        continue;
                    }
                }
                strBuilder.append("-");
            }
            return result;
        }

}
