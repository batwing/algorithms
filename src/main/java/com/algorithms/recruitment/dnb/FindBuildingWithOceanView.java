package com.algorithms.recruitment.dnb;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class FindBuildingWithOceanView {
    public Integer[] getIndexesOfBuildingWithTheView(Integer[] buildingHeights){
        if (buildingHeights == null || buildingHeights.length == 0)
            return new Integer[]{};

        int currentTallestBuilding = 0;
        List<Integer> indexes = new LinkedList<>();

        for (int i=buildingHeights.length-1; i>=0; i--){

            if (currentTallestBuilding < buildingHeights[i]) {
                indexes.add(i);
                currentTallestBuilding = buildingHeights[i];
            }
        }

        Integer[] result = indexes.toArray(new Integer[indexes.size()]);
        Arrays.sort(result, Comparator.naturalOrder());

        return result;
    }
}
