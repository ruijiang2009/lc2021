package com.myrj.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question562Test {
  Question562 solution = new Question562();

  @Test
  public void test1() {
    int[][] M = {{1,1,1,1},{0,1,1,0},{0,0,0,1}};
    Assert.assertEquals(4, solution.longestLine(M));
  }

  @Test
  public void test2() {
    int[][] M = {{1}};
    Assert.assertEquals(1, solution.longestLine(M));
  }

  @Test
  public void test3() {
    int[][] M = {{0, 0}, {1, 1}};
    Assert.assertEquals(2, solution.longestLine(M));
  }

  @Test
  public void test4() {
    int[][] M = {{0,1,1,0},{0,1,1,0},{0,0,0,1}};
    Assert.assertEquals(3, solution.longestLine(M));
  }

  @Test
  public void test5() {
    int[][] M = {{1,1,1,1},{0,1,1,0},{0,0,0,1}};
    Assert.assertEquals(4, solution.longestLine(M));
  }


  @Test
  public void test6() {
    int[][] M =
        {
            {1,1,0,0,1,0,0,1,1,0},
            {1,0,0,1,0,1,1,1,1,1},
            {1,1,1,0,0,1,1,1,1,0},
            {0,1,1,1,0,1,1,1,1,1},
            {0,0,1,1,1,1,1,1,1,0},
            {1,1,1,1,1,1,0,1,1,1},
            {0,1,1,1,1,1,1,0,0,1},
            {1,1,1,1,1,0,0,1,1,1},
            {0,1,0,1,1,0,1,1,1,1},
            {1,1,1,0,1,0,1,1,1,1}
        };


    Assert.assertEquals(9, solution.longestLine(M));
  }
}
