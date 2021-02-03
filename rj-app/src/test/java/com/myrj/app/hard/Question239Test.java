package com.myrj.app.hard;

import org.junit.Assert;
import org.junit.Test;

public class Question239Test {
  Question239 solution = new Question239();

  @Test
  public void test1() {
    int[] nums = {10,2,-10,5,20};
    int[] result = solution.maxSlidingWindow(nums, 2);
    Assert.assertArrayEquals(new int[]{10, 2, 5, 20}, result );
  }

  @Test
  public void test2() {
    int[] nums = {1,3,-1,-3,5,3,6,7};
    int[] result = solution.maxSlidingWindow(nums, 3);
    Assert.assertArrayEquals(new int[]{3,3,5,5,6,7}, result );
  }

  @Test
  public void test3() {
    int[] nums = {1,3,1,2,0,5};
    int[] result = solution.maxSlidingWindow(nums, 3);
    Assert.assertArrayEquals(new int[]{3,3,2,5}, result );
  }
}
