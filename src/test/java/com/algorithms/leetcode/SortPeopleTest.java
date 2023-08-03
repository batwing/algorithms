package com.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SortPeopleTest {

    @Test
    void testSortPeopleShouldReturnNamesInDescOrderByHeighWhenAllPeopleDIfferent() {
        String[] result = new SortPeople()
                .sortPeople(
                        new String[]{"Mary","John","Emma"},
                        new int[]{180,165,170}
        );

        assertThat(result).isEqualTo(new String[]{"Mary","Emma","John"});
    }
}