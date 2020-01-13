package com.algorithms.recruitment.classic.strings;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UniqueCharacters {
    private String text;

    //For the case when the text is limmited by symbols from 'a' to 'z' in low registry
    public boolean isUniqueTimeOnMemoryOconstant1() throws Exception{
        int checker = 0;//the mask of 28 positions (from 'a' to 'z')
        int maxRange = 'z' - 'a';

        for(int i=0;i<text.length(); i++){
            if (text.charAt(i) < 'a' || text.charAt(i) > 'z') {
                throw new Exception("text includes characters that are out of the range(a-z)");
            }
            int value = 1 << text.charAt(i) - 'a';//we need a data type that can include at least 28 bits

            if ((checker & value) > 0){
                return false;
            }
            checker |= value;
        }

        return true;
    }

    //For the case when characters are from ASCII {1..128}
    public boolean isUniqueTimeOnMemoryOconstant2() throws Exception{
        boolean[] checker = new boolean[128];

        for(int i=0;i<text.length(); i++){
            if (checker[text.charAt(i)]) {
                return false;
            }
            checker[text.charAt(i)] = true;
        }

        return true;
    }
}
