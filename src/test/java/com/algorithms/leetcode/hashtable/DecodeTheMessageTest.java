package com.algorithms.leetcode.hashtable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DecodeTheMessageTest {

    @Test
    void decodeShouldDecodeUsingLettersFromKeyWhenThereAreEnoughKeys1() {
        String expectedResult = "this is a secret";
        String actualResult = new DecodeTheMessage().decode("the quick brown fox jumps over the lazy dog","vkbs bs t suepuv");
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void decodeShouldDecodeUsingLettersFromKeyWhenThereAreEnoughKeys2() {
        String expectedResult = "the five boxing wizards jump quickly";
        String actualResult = new DecodeTheMessage().decode("eljuxhpwnyrdgtqkviszcfmabo","zwx hnfx lqantp mnoeius ycgk vcnjrdb");
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}