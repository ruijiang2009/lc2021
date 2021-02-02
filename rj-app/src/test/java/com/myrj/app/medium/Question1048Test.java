package com.myrj.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question1048Test {
  Question1048 solution = new Question1048();

  @Test
  public void test1() {
    String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
    Assert.assertEquals(4, solution.longestStrChain(words));
  }

  @Test
  public void test2() {
    String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
    Assert.assertEquals(5, solution.longestStrChain(words));
  }

  @Test
  public void test3() {
    String[] words = {"abcd","dbqca"};
    Assert.assertEquals(1, solution.longestStrChain(words));
  }
}