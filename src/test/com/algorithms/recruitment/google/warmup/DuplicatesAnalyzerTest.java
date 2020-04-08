package com.algorithms.recruitment.google.warmup;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DuplicatesAnalyzerTest {
  @Test
  public void shouldNotFindCycleInEmptyArray() {
    assertFalse(new ArrayCyclingAnalyzer().isCyclingInArray(new int[] {}));
  }

  @Test
  public void shouldNotFindCycleInSeqArray() {
    assertFalse(new ArrayCyclingAnalyzer().isCyclingInArray(new int[] {1,2,3,4,5}));
  }

  @Test
  public void shouldFindCycleWhenArrayHasDuplicates() {
    assertTrue(new ArrayCyclingAnalyzer().isCyclingInArray(new int[] {1,2,1,4,5}));
  }
}
