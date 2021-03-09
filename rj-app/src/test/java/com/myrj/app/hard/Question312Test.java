package com.myrj.app.hard;

import org.junit.Assert;
import org.junit.Test;

public class Question312Test {
  Question312 solution = new Question312();

  @Test
  public void test1() {
    int[] nums = {3,1,5,8};
    int result = solution.maxCoins(nums);
    Assert.assertEquals(result, 167);
  }
}
