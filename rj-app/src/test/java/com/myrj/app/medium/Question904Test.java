package com.myrj.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question904Test {
  Question904 solution = new Question904();

  @Test
  public void test1() {
    int[] input = {3,3,3,1,2,1,1,2,3,3,4};
    Assert.assertEquals(5, solution.totalFruit(input));
  }

  @Test
  public void test2() {
    int[] input = {1,2,3,2,2};
    Assert.assertEquals(4, solution.totalFruit(input));
  }

  @Test
  public void test3() {
    int[] input = {0,1,2,2};
    Assert.assertEquals(3, solution.totalFruit(input));
  }

  @Test
  public void test4() {
    int[] input = {1,2,1};
    Assert.assertEquals(3, solution.totalFruit(input));
  }
}
