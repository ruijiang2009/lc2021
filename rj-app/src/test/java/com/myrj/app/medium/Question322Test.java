package com.myrj.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question322Test {
  Question322 solution = new Question322();
  @Test
  public void test1() {
    int[] coins = {1, 2, 5};
    int result = solution.coinChange(coins, 11);
    Assert.assertEquals(3, result);
  }

  @Test
  public void test2() {
    int[] coins = {2};
    int result = solution.coinChange(coins, 4);
    Assert.assertEquals(2, result);
  }

  @Test
  public void test3() {
    int[] coins = {2};
    int result = solution.coinChange(coins, 3);
    Assert.assertEquals(-1, result);
  }

}
