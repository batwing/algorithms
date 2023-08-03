package com.algorithms.recruitment.dnb;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindBuildingWithOceanViewTest {

    /*
    Input: heights = [4,2,3,1]
    Output: [0,2,3]
     */
    @Test
    public void testSolutionShouldReturnOnlyTheBuildingWithView() {
        Integer[] result = new FindBuildingWithOceanView().getIndexesOfBuildingWithTheView(new Integer[]{4,2,3,1});
        assertThat(result).isEqualTo(new int[]{0,2,3});
    }

    /*
    Input: heights = [4,3,2,1]
Output: [0,1,2,3]
     */
    @Test
    public void testSolutionShouldReturnAllTheBuildingWithViewWhenTheyAreInCorrectOrder() {
        Integer[] result = new FindBuildingWithOceanView().getIndexesOfBuildingWithTheView(new Integer[]{4,3,2,1});
        assertThat(result).isEqualTo(new int[]{0,1,2,3});
    }
}