package com.algorithms.recursion.pwdcracker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    static final String WRONG_PWD_MSG = "WRONG PASSWORD";

    public static List<String> findWordsInText(List<String> words, String text, int startPos, int strLen) {
        List<String> result = new ArrayList<>();
        words.stream()
                .filter(w -> w.equals(text));

        String nextSubstring =
        for (text)
    }

    public static List<String> getAllSubstrings(String text){
        List<String> result = new ArrayList<>();
        return result;
    }
    /*
     * Complete the 'passwordCracker' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY passwords
     *  2. STRING loginAttempt
     */

    public static String passwordCracker(List<String> passwords, String loginAttempt) {
        List<String> result = new ArrayList<>();

        if (loginAttempt == null || "".equals(loginAttempt)) {
            return WRONG_PWD_MSG;
        }

        if (passwords == null || passwords.isEmpty()) {
            return "";
        }

        List<String> substrings = getAllSubstrings(loginAttempt);

        for (String substring: substrings) {
            result.addAll(findWordsInText(passwords, substring, 0, 1));
        }

        return result.isEmpty() ? WRONG_PWD_MSG : result.stream().collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws IOException {
        List<String> existentPasswords = Arrays.asList(new String[] {"because", "can", "do", "must", "we", "what"});
        String loginAttempt = "wedowhatwemustbecausewecan";
        String result = passwordCracker(existentPasswords, loginAttempt);
    }
}
