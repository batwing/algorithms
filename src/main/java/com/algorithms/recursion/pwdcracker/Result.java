package com.algorithms.recursion.pwdcracker;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Result {

    static final String WRONG_PWD_MSG = "WRONG PASSWORD";
    private int theLongestPwdLength;
    private List<String> passwords;

    public Result(List<String> passwords) {
        this.passwords = passwords;
        this.theLongestPwdLength = getTheLongestWordSize(passwords);
    }

    private Integer getTheLongestWordSize(List<String> words){
        if (words == null)
            return 0;

        return
                words.stream()
                .max(Comparator.comparing(String::length))
                .orElse("").length();
    }

    private Integer findPwdInText(LinkedList<String> foundWordsStack, String text, Integer startPos, Integer strLen) {
        Integer endPos = startPos+strLen;
        String partOfTextToAnalyze = text.substring(startPos, endPos);

        if (passwords.contains(partOfTextToAnalyze)) {
            foundWordsStack.add(partOfTextToAnalyze);
            startPos = endPos;
            strLen = 1;
        }
        else {
            strLen++;
        }

        if (strLen > theLongestPwdLength){
            String wrongWord = foundWordsStack.removeLast();
            startPos = startPos - wrongWord.length();
            strLen = wrongWord.length() + 1;
        }

        if (startPos >= text.length() || endPos >= text.length() )
            return startPos;

        return findPwdInText(foundWordsStack, text, startPos, strLen);
    }

    private boolean isTextContainOnlyPwd(List<String> foundWords, String text, Integer currentPos){
        return !foundWords.isEmpty() && (currentPos >= text.length());
    }

    public String passwordCracker(String loginAttempt) {
        LinkedList<String> result = new LinkedList<>();

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
        //List<String> existentPasswords = Arrays.asList(new String[] {"because", "can", "do", "must", "we", "what"});
        //String loginAttempt = "wedowhatwemustbecausewecan";
        /*
        List<String> existentPasswords = Arrays.asList(new String[] {"the", "cake", "is", "a", "lie", "thec", "ak", "ei", "sal", "ie"});
        String loginAttempt = "thecakeisaliethecakeisalieakthecakeisaliethecakeisalie" +
                "thecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisalie" +
                "thecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisalie" +
                "thecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisalie" +
                "thecakeisaliethecakeisaliethecakeisalieathecakeisaliethecakeisaliethecakeisalie" +
                "thecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethethecakeisalie" +
                "thecakeisaliethecakeisaliethecakeisaliethethecakeisalieakthecakeisalie" +
                "thecakeisaliethecakeisaliethecakeisaliethecakeisaliesalthecakeisaliethecakeisalie" +
                "thecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliesal" +
                "thecakeisaliethecakeisalielieakthecakeisalieliethecakeisaliethecakeisaliethecakeisalie" +
                "thecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisalie" +
                "thecakeisaliethecakeisaliethecakeisalieakthecakeisaliethecakeisaliethecakeisaliethecakeisalie" +
                "thecakeisalieeithecakeisaliethecakeisalieeithecakeisaliethecakeisaliethecakeisalie" +
                "thecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisalie" +
                "thecakeisalieiethecakeisaliethecakeisaliethecakeisaliethecakeisalieisthecakeisalie" +
                "thecakeisalieiscakeakthecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisalie" +
                "thecakeisaliethecakeisaliethecakeisalieakcakethecakeisaliethecieiethecthecakeisaliethecakeisalie" +
                "thecakeisaliethecakeisaliethecakeisalieeithecakeisaliethecakeisaliethecakeisaliethecakeisalie" +
                "thecakeisalieathecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisalie" +
                "thecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisalie" +
                "thecakeisalieeithecakeisaliethecakeisaliethecakeisaliethecakeisalieacakethecakeisaliethecakeisaliesal" +
                "thecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisalieak" +
                "thecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisaliethecakeisalie" +
                "thecakeisaliethecakeisalie";
        */
        List<String> existentPasswords = Arrays.asList(new String[] {"we", "web", "adaman", "barcod"});
        String loginAttempt = "webadaman";

        String result = new Result(existentPasswords).passwordCracker(loginAttempt);
        System.out.println("result = " + result);
    }
}
