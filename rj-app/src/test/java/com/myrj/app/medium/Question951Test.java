package com.myrj.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question951Test {
  private Question951 solution = new Question951();

  @Test
  public void test1() {
    Question951.TreeNode root1 = new Question951.TreeNode(1);
    root1.left = new Question951.TreeNode(2);
    root1.right = new Question951.TreeNode(3);
    root1.left.left = new Question951.TreeNode(4);
    root1.left.right = new Question951.TreeNode(5);
    root1.left.right.left = new Question951.TreeNode(7);
    root1.left.right.right = new Question951.TreeNode(8);
    root1.right.left = new Question951.TreeNode(6);

    Question951.TreeNode root2 = new Question951.TreeNode(1);
    root2.right = new Question951.TreeNode(2);
    root2.left = new Question951.TreeNode(3);
    root2.right.left = new Question951.TreeNode(4);
    root2.right.right = new Question951.TreeNode(5);
    root2.right.right.right = new Question951.TreeNode(7);
    root2.right.right.left = new Question951.TreeNode(8);
    root2.left.right = new Question951.TreeNode(6);

    Assert.assertTrue(solution.flipEquiv(root1, root2));
  }
}
