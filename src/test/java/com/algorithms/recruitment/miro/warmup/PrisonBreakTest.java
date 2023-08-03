package com.algorithms.recruitment.miro.warmup;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrisonBreakTest {

    @Test
    void solutionBasedOnMinHeapShouldReturn4WhenOnlyOneRowAndOneColumnAreDeleted() {
        int biggestSquare = new PrisonBreak().getTheBiggestSquareUsingMinHeap(6, 6, new int[]{4}, new int[]{2});
        assertThat(biggestSquare).isEqualTo(4);
    }

    @Test
    void solutionBasedOnMinHeapShouldReturn2WhenThereAreNoDeletedRowsOrColumns() {
        int biggestSquare = new PrisonBreak().getTheBiggestSquareUsingMinHeap(6, 6, new int[]{}, new int[]{});
        assertThat(biggestSquare).isEqualTo(1);
    }

    @Test
    void solutionBasedOnMinHeapShouldReturn6WhenThereAre2RowsAnd1ColumnDeleted() {
        int biggestSquare = new PrisonBreak().getTheBiggestSquareUsingMinHeap(6, 6, new int[]{2,3}, new int[]{1});
        assertThat(biggestSquare).isEqualTo(6);
    }

    @Test
    void solutionBasedOnMinHeapShouldReturn6WhenThereAre2RowsAtMaxDeleted() {
        int biggestSquare = new PrisonBreak().getTheBiggestSquareUsingMinHeap(12, 6, new int[]{3,2,3,2,5,2,6,2,8,2,9}, new int[]{});
        assertThat(biggestSquare).isEqualTo(3);
    }

    @Test
    void solutionBasedOnHashsetShouldReturn4WhenOnlyOneRowAndOneColumnAreDeleted() {
        int biggestSquare = new PrisonBreak().getTheBiggestSquareUsingHashSet(6, 6, new int[]{4}, new int[]{2});
        assertThat(biggestSquare).isEqualTo(4);
    }

    @Test
    void solutionBasedOnHashsetShouldReturn2WhenThereAreNoDeletedRowsOrColumns() {
        int biggestSquare = new PrisonBreak().getTheBiggestSquareUsingHashSet(6, 6, new int[]{}, new int[]{});
        assertThat(biggestSquare).isEqualTo(1);
    }

    @Test
    void solutionBasedOnHashsetShouldReturn6WhenThereAre2RowsAnd1ColumnDeleted() {
        int biggestSquare = new PrisonBreak().getTheBiggestSquareUsingHashSet(6, 6, new int[]{2,3}, new int[]{1});
        assertThat(biggestSquare).isEqualTo(6);
    }

    @Test
    void solutionBasedOnHashsetShouldReturn6WhenThereAre2RowsAtMaxDeleted() {
        int biggestSquare = new PrisonBreak().getTheBiggestSquareUsingHashSet(12, 6, new int[]{3,2,3,2,5,2,6,2,8,2,9}, new int[]{});
        assertThat(biggestSquare).isEqualTo(3);
    }

    @Test
    void linearSolutionShouldReturn4WhenOnlyOneRowAndOneColumnAreDeleted() {
        int biggestSquare = new PrisonBreak().getTheBiggestSquareBasedOnSorting(6, 6, new int[]{4}, new int[]{2});
        assertThat(biggestSquare).isEqualTo(4);
    }

    @Test
    void linearSolutionShouldReturn2WhenThereAreNoDeletedRowsOrColumns() {
        int biggestSquare = new PrisonBreak().getTheBiggestSquareBasedOnSorting(6, 6, new int[]{}, new int[]{});
        assertThat(biggestSquare).isEqualTo(1);
    }

    @Test
    void linearSolutionShouldReturn6WhenThereAre2RowsAnd1ColumnDeleted() {
        int biggestSquare = new PrisonBreak().getTheBiggestSquareBasedOnSorting(6, 6, new int[]{2,3}, new int[]{1});
        assertThat(biggestSquare).isEqualTo(6);
    }

    @Test
    void linearSolutionShouldReturn6WhenThereAre2RowsAtMaxDeleted() {
        int biggestSquare = new PrisonBreak().getTheBiggestSquareBasedOnSorting(12, 6, new int[]{3,2,3,2,5,2,6,2,8,2,9}, new int[]{});
        assertThat(biggestSquare).isEqualTo(3);
    }
}