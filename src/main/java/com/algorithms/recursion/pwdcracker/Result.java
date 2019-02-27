package com.algorithms.recursion.pwdcracker;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Result {

    static final String WRONG_PWD_MSG = "WRONG PASSWORD";
    private List<String> passwords;

    public Result(List<String> passwords) {
        this.passwords = passwords;
    }

    private Integer findPwdInText(Set<String> foundWords, String text, Integer startPos, Integer strLen) {
        Integer endPos = startPos+strLen;
        String partOfTextToAnalyze = text.substring(startPos, endPos);

        if (passwords.contains(partOfTextToAnalyze)) {
            foundWords.add(partOfTextToAnalyze);
            startPos = endPos;
            strLen = 1;
        }
        else {
            strLen++;
        }

        if (startPos >= text.length() || endPos >= text.length())
            return startPos;

        return findPwdInText(foundWords, text, startPos, strLen);
    }

    private boolean isTextContainOnlyPwd(Set<String> foundWords, String text, Integer currentPos){
        return !foundWords.isEmpty() && (currentPos >= text.length());
    }

    /*
     * Complete the 'passwordCracker' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY passwords
     *  2. STRING loginAttempt
     */

    public String passwordCracker(String loginAttempt) {
        Set<String> result = new HashSet<>();

        if (loginAttempt == null || "".equals(loginAttempt)) {
            return WRONG_PWD_MSG;
        }

        if (passwords == null || passwords.isEmpty()) {
            return "";
        }

        Integer currentPos = 0;
        currentPos = findPwdInText(result, loginAttempt, currentPos, 1);

        return isTextContainOnlyPwd(result, loginAttempt, currentPos)
                ? result.stream().collect(Collectors.joining(" "))
                : WRONG_PWD_MSG;
    }

    public static void main(String[] args) throws IOException {
        List<String> existentPasswords = Arrays.asList(new String[] {"because", "can", "do", "must", "we", "what"});
        String loginAttempt = "wedowhatwemustbecausewecan";
        String result = new Result(existentPasswords).passwordCracker(loginAttempt);
        System.out.println("result = " + result);
    }
}
