package com.myrj.app.hard;

import org.junit.Test;

public class Question471Test {
  Question471 solution = new Question471();

  @Test
  public void test1() {
    String s = "ababababcababababababcbbbbbb";
    String result = solution.encode(s);
    System.out.println(result);
  }

  @Test
  public void test2() {
    String s = "ababcababc";
    String result = solution.encode(s);
    System.out.println(result);
  }
}
