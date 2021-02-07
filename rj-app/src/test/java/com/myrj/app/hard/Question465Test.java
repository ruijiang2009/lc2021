package com.myrj.app.hard;

import org.junit.Assert;
import org.junit.Test;

public class Question465Test {
  Question465 solution = new Question465();

  @Test
  public void test1() {
    int[][] transactions = {{0,1,1},{1,2,1},{2,0,1}};
    Assert.assertEquals(0, solution.minTransfers(transactions));
  }

  @Test
  public void test2() {
    int[][] transactions = {{1,5,8},{8,9,8},{2,3,9},{4,3,1}};
    Assert.assertEquals(4, solution.minTransfers(transactions));
  }
}

