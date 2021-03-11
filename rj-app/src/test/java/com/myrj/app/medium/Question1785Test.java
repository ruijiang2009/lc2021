package com.myrj.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question1785Test {
  Question1785 solution = new Question1785();

  @Test
  public void test1() {
    int[] nums = {1, -1, 1};
    int limit = 3;
    int goal = -4;
    Assert.assertEquals(2, solution.minElements(nums, limit, goal));
  }

  @Test
  public void test2() {
    int[] nums = {1, -10, 9, 1};
    int limit = 100;
    int goal = 0;
    Assert.assertEquals(1, solution.minElements(nums, limit, goal));
  }

}
