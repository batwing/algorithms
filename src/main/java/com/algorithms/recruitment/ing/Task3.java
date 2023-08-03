package com.algorithms.recruitment.ing;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public int quadraticSolution(int[] A) {
        int N = A.length;
        int result = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (A[i] == A[j])
                    result = Math.max(result, Math.abs(i - j));
        return result;
    }

    public int linearSolution(int[] A) {
        Map<Integer, DuplicateInfo> duplicateInfoMap = new HashMap<>();
        int longestDistance = 0;
        for (int i=0; i<A.length; i++){
            if (duplicateInfoMap.containsKey(A[i])){
                DuplicateInfo item = duplicateInfoMap.get(A[i]);
                item.setDistance(i - item.getStartPos());
                if (longestDistance < item.getDistance()) {
                    longestDistance = item.getDistance();
                }
            }
            else {
                duplicateInfoMap.put(A[i], new DuplicateInfo(i,0));
            }

        }
        return longestDistance;

    }

    private class DuplicateInfo {
        int startPos;
        int distance;

        public DuplicateInfo(int startPos, int distance) {
            this.startPos = startPos;
            this.distance = distance;
        }

        public int getStartPos() {
            return startPos;
        }

        public void setStartPos(int startPos) {
            this.startPos = startPos;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}
