package com.algorithms.dynamic.programming;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*****************************************************************

 Dynamic programming: Find the largest square of 1's in A Matrix

 Test1
 in: 0
 out: 0

 Test2
 in: 1
 out: 1

 Test3
 in:
 11
 11
 out: 2

 Test4
 in:
 01
 11
 out: 1

 Test5
 in:
 11010
 01110
 11011
 01111

 out: 2

 Test6
 in:
 11010
 01110
 11110
 01111

 out: 3


 ************************************/

public class SquareFinderTest {
  @Test
  public void shouldNotFindAnything() {
    assertEquals(0,
        new SquareFinder().getLargestSquare(
            new int[][] {{0}})
    );
  }

  @Test
  public void shouldFindSmallestIn1DimMatrix() {
    assertEquals(1,
        new SquareFinder().getLargestSquare(
            new int[][] {{1}})
    );
  }

  @Test
  public void shouldFind2DimSizeWhenAll1s() {
    assertEquals(2,
        new SquareFinder().getLargestSquare(
              new int[][] {
                  {1,1},
                  {1,1}
              }
            )
    );
  }

  @Test
  public void shouldFindSmallestWhenNotAll1s() {
    assertEquals(1,
        new SquareFinder().getLargestSquare(
              new int[][] {
                {0,1},
                {1,1}
              }
            )
    );
  }

  @Test
  public void shouldFind2DimSizeWhenNotAll1s() {
    assertEquals(2,
        new SquareFinder().getLargestSquare(
            new int[][] {
              {1,1,0,1,0},
              {0,1,1,1,0},
              {1,1,0,1,1},
              {0,1,1,1,1}
          })
    );
  }

  @Test
  public void shouldFind3DimSizeWhenNotAll1s() {
    assertEquals(3,
        new SquareFinder().getLargestSquare(
            new int[][] {
              {1,1,0,1,0},
              {0,1,1,1,0},
              {1,1,1,1,1},
              {0,1,1,1,1}
          })
    );
  }
}
