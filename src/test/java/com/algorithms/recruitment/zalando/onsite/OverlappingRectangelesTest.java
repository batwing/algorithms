package com.algorithms.recruitment.zalando.onsite;

import com.algorithms.recruitment.zalando.onsite.OverlappingRectangeles;
import com.algorithms.recruitment.zalando.onsite.OverlappingRectangeles.Point;
import com.algorithms.recruitment.zalando.onsite.OverlappingRectangeles.Rectangle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class OverlappingRectangelesTest {
  @Test
  public void shouldNotOverlapWhenRectsHaveNoCommonBorders() {
    assertFalse(new OverlappingRectangeles().areRectsOverlapping(new Rectangle(new Point(1,1), new Point(2,2)), new Rectangle(new Point(3,3), new Point(4,4))));
  }

  @Test
  public void shouldNotOverlapWhenRectsHaveOneCommonBorder() {
    assertFalse(new OverlappingRectangeles().areRectsOverlapping(new Rectangle(new Point(1,1), new Point(2,2)), new Rectangle(new Point(2,2), new Point(3,3))));
  }

  @Test
  public void shouldOverlapWhenDistanceBetweenBordersPositiveIn1stQuarter() {
    assertTrue(new OverlappingRectangeles().areRectsOverlapping(new Rectangle(new Point(1,1), new Point(4,4)), new Rectangle(new Point(2,2), new Point(5,5))));
  }

  @Test
  public void shouldOverlapWhenDistanceBetweenBordersPositiveIn3rdQuarter() {
    assertTrue(new OverlappingRectangeles().areRectsOverlapping(new Rectangle(new Point(-4,-4), new Point(-1,-1)), new Rectangle(new Point(-5,-5), new Point(-2,-2))));
  }

  @Test
  public void shouldNotOverlapWhenRectsAreInDifQuarters() {
    assertFalse(new OverlappingRectangeles().areRectsOverlapping(new Rectangle(new Point(-4,-4), new Point(-1,-1)), new Rectangle(new Point(2,2), new Point(5,5))));
  }
}
