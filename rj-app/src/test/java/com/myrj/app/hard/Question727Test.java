package com.myrj.app.hard;

import org.junit.Assert;
import org.junit.Test;

public class Question727Test {
  Question727 solution = new Question727();

  @Test
  public void test1() {
    String s = "abcdebdde";
    String t = "bde";
    Assert.assertEquals("bcde", solution.minWindow(s, t));
  }

  @Test
  public void test2() {
    String s = "abcdebde";
    String t = "bde";
    Assert.assertEquals("bde", solution.minWindow(s, t));
  }
}
