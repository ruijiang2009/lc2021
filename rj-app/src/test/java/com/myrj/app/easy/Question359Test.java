package com.myrj.app.easy;

import org.junit.Assert;
import org.junit.Test;

public class Question359Test {
  @Test
  public void test1() {
    Question359.Logger logger = new Question359.Logger();
    Assert.assertTrue(logger.shouldPrintMessage(1, "foo"));
    Assert.assertTrue(logger.shouldPrintMessage(2, "bar"));
    Assert.assertFalse(logger.shouldPrintMessage(3, "foo"));
    Assert.assertFalse(logger.shouldPrintMessage(8, "bar"));
    Assert.assertFalse(logger.shouldPrintMessage(10, "foo"));
    Assert.assertTrue(logger.shouldPrintMessage(11, "foo"));
  }
}
