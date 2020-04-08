package com.algorithms.recruitment.zalando.onsite;

import static java.lang.Integer.max;
import static java.lang.Math.min;
import lombok.AllArgsConstructor;

/** Zalando coding intervie warmup ***

 Check if two rectangles are overlapping on Cartesian coordinate system

 Test1
 in:
 Rect1(1,1,2,2)
 Rect2(3,3,4,4)

 out: false

 Test2
 in:
 Rect1(1,1,2,2)
 Rect2(2,2,3,3)

 out: false

 Test3
 in:
 Rect1(1,1,4,4)
 Rect2(2,2,5,5)

 out: true

 Test4
 in:
 Rect1(-4,-4,-1,-1)
 Rect2(-5,-5,-2,-2)

 out: true

 Test5
 in:
 Rect1(-4,-4,-1,-1)
 Rect2(2,2,5,5)

 out: false
 ************************************/

public class OverlappingRectangeles {
  public Boolean areRectsOverlapping(Rectangle rect1, Rectangle rect2){
    int distX = distance(rect1.leftBottomPoint.x, rect1.rightTopPoint.x,
        rect2.leftBottomPoint.x, rect2.rightTopPoint.x);
    int distY = distance(rect1.leftBottomPoint.y, rect1.rightTopPoint.y,
        rect2.leftBottomPoint.y, rect2.rightTopPoint.y);

    return distX > 0 && distY > 0;
  }

  private int distance(int line1Start, int line1End, int line2Start, int line2End){
    return min(line1End, line2End) - max(line1Start, line2Start);
  }

  @AllArgsConstructor
  public static class Point {
    private final int x;
    private final int y;
  }

  @AllArgsConstructor
  public static class Rectangle {
    private final Point leftBottomPoint;
    private final Point rightTopPoint;
  }
}
