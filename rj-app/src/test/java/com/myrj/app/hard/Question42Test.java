package com.myrj.app.hard;

import org.junit.Test;

public class Question42Test {
  Question42 solution = new Question42();

  @Test
  public void test1() {
    int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    int result = solution.trap(height);
    System.out.println(result);
  }

  @Test
  public void test2() {
    int[] height = {4,2,0,3,2,5};
    int result = solution.trap(height);
    System.out.println(result);
  }
}
