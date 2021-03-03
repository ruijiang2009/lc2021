package com.myrj.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question698Test {
  Question698 solution = new Question698();
  @Test
  public void test1() {
    int[] input = {4,5,3,2,5,5,5,1,5,5,5,5,5,5,5,5};
    int k = 14;
    boolean result = solution.canPartitionKSubsets(input, k);
    Assert.assertTrue(result);
  }

  @Test
  public void test3() {
    int[] input = {5,2,5,5,5,5,5,5,5,5,5,5,5,5,5,3};
    int k = 15;
    boolean result = solution.canPartitionKSubsets(input, k);
    Assert.assertTrue(result);
  }

  @Test
  public void test2() {
    int[] input = {4,5,3,2,5,5,5,1,5,5,5,5,5,5,5,5};
    int k = 14;
    boolean result = solution.canPartitionKSubsets2(input, k);
    Assert.assertTrue(result);
  }

  @Test
  public void test4() {
    int[] input = {5,2,5,5,5,5,5,5,5,5,5,5,5,5,5,3};
    int k = 15;
    boolean result = solution.canPartitionKSubsets2(input, k);
    Assert.assertTrue(result);
  }
}
