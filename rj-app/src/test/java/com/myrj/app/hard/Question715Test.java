package com.myrj.app.hard;

import org.junit.Assert;
import org.junit.Test;

public class Question715Test {

  @Test
  public void test1() {
    Question715.RangeModule solution = new Question715.RangeModule();

    solution.addRange(2, 5);
    solution.addRange(4, 5);
    solution.addRange(3, 6);
    Assert.assertEquals(true, solution.queryRange(3, 4));
    Assert.assertEquals(true, solution.queryRange(3, 5));
    Assert.assertEquals(true, solution.queryRange(2, 6));
    solution.removeRange(3, 4);
    Assert.assertEquals(false, solution.queryRange(3, 4));
  }
}
