package com.algorithms.recruitment.yandex.training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StonesAndJeweleries {
        public static int countJeweleriesAmongStones(String jew, String stones){
            int result = 0;
            if (jew == null || "".equals(jew) || stones == null || "".equals(stones))
                return 0;

            Set<Character> setOfJ = jew.chars().mapToObj(c -> (char)c).collect(Collectors.toSet());

            for(char c: stones.toCharArray()){
                if (setOfJ.contains(c)) {
                    result++;
                }
            }
            return result;
        }

        public static void main(String[] args) throws Exception {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            String j = r.readLine();
            String s = r.readLine();

            System.out.println(countJeweleriesAmongStones(j, s));

        }
}
