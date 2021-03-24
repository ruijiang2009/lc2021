package com.myrj.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question1774Test {
  Question1774 solution = new Question1774();

  @Test
  public void test1() {
    int[] baseCosts = {2, 3};
    int[] toppings = {4, 5, 100};
    int target = 18;
    Assert.assertEquals(17, solution.closestCost(baseCosts, toppings, target));
  }

  @Test
  public void tes21() {
    int[] baseCosts = {1};
    int[] toppings = {8, 10};
    int target = 10;
    Assert.assertEquals(9, solution.closestCost(baseCosts, toppings, target));
  }
}
