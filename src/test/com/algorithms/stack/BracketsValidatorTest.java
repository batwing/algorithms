package com.algorithms.stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BracketsValidatorTest {
  @Test
  public void shouldWorkWellOnEmptyString() {
    assertTrue(new BracketsValidator().isBracketsSeqValid(""));
  }

  @Test
  public void shouldWorkWellWithoutBrackets() {
    assertTrue(new BracketsValidator().isBracketsSeqValid("abc"));
  }

  @Test
  public void shouldFindAll3BracketsPlacedInCorrectSeq() {
    assertTrue(new BracketsValidator().isBracketsSeqValid("{([])}"));
  }

  @Test
  public void shouldDetectDifTypesOfOpenCloseBrackets() {
    assertFalse(new BracketsValidator().isBracketsSeqValid("abc{)("));
  }

  @Test
  public void shouldDetectIncorrectSeq() {
    assertFalse(new BracketsValidator().isBracketsSeqValid(")("));
  }
}
