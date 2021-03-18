package com.myrj.app.medium;

import com.myrj.app.model.TreeNode;
import org.junit.Test;

public class Question536Test {
  Question536 solution = new Question536();

  @Test
  public void test1() {
    TreeNode node = solution.str2tree("4(2(3)(1))(6(5))");
    System.out.println(node.val);
  }
}
