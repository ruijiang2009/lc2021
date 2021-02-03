package com.myrj.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question792Test {
  Question792 solution = new Question792();

  @Test
  public void test1() {
    String[] words = {"a", "bb", "acd", "ace"};
    String s = "abcde";
    Assert.assertEquals(3, solution.numMatchingSubseq(s, words));
  }

  @Test
  public void test2() {
    String s = "dsahjpjauf";
    String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
    Assert.assertEquals(0, solution.numMatchingSubseq(s, words));
  }
}
