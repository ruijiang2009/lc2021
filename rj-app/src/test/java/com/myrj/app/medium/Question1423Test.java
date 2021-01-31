package com.myrj.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question1423Test {
  Question1423 solution = new Question1423();

  @Test
  public void test1() {
    int[] cardPoints = {1,2,3,4,5,6,1};
    int k = 3;
    int result = solution.maxScore(cardPoints, k);
    Assert.assertEquals(12, result);
  }

  @Test
  public void test2() {
    int[] cardPoints = {1,2,10,4,5,6,1};
    int k = 3;
    int result = solution.maxScore(cardPoints, k);
    Assert.assertEquals(13, result);
  }
}
