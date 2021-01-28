package com.myrj.app.easy;

import org.junit.Assert;
import org.junit.Test;

public class Question1736Test {
  Question1736 solution = new Question1736();

  @Test
  public void test1() {
    String input = "2?:?0";
    String output = solution.maximumTime(input);
    Assert.assertEquals(output, "23:50");
  }

  @Test
  public void test2() {
    String input = "0?:3?";
    String output = solution.maximumTime(input);
    Assert.assertEquals(output, "09:39");
  }

  @Test
  public void test3() {
    String input = "1?:22";
    String output = solution.maximumTime(input);
    Assert.assertEquals(output, "19:22");
  }
}
