package com.algorithms.dynamic.programming;

import static java.lang.Math.min;

public class SquareFinder {
  public int getLargestSquare(int[][] matrix){
    int result =0;
    int[][] cash = new int[matrix.length][matrix[0].length];

    for (int i=0; i<matrix.length; i++) {
      System.arraycopy(matrix[i], 0, cash[i], 0, matrix[i].length);
    }

    for (int y=0; y < matrix.length; y++) {
      for (int x=0; x < matrix[y].length; x++) {
        if (x==0 || y==0) {
          if (matrix[y][x] > 0 && result <= 0) {
            result = matrix[y][x];
          }
          continue;
        }

        if (cash[y][x] >= 1) {
          cash[y][x] = min(cash[y - 1][x], min(cash[y - 1][x - 1], cash[y][x - 1])) + 1;
        }

        if (result < cash[y][x]) {
          result = cash[y][x];
        }

      }
    }

    return result;

  }
}
