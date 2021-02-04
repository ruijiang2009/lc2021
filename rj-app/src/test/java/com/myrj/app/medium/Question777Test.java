package com.myrj.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question777Test {
  Question777 solution = new Question777();

  @Test
  public void test1() {
    String s = "RXXLRXRXL";
    String e = "XRLXXRRLX";
    Assert.assertTrue(solution.canTransform(s, e));
  }
}
