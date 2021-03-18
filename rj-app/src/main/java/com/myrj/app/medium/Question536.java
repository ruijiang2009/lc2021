package com.myrj.app.medium;

import com.myrj.app.model.TreeNode;

import java.util.Stack;

public class Question536 {
  public TreeNode str2tree(String s) {
    if (s == null || s.length() == 0) {
      return null;
    }
    int start = 0;
    int end = 0;
    Stack<TreeNode> stack = new Stack<>();
    while(end <= s.length()-1) {
      if (s.charAt(end) == '(') {
        start = end + 1;
      } else if (s.charAt(end) == ')') {
        stack.pop();
        start = end + 1;
      } else {
        while(end+1 < s.length() && s.charAt(end+1) != '(' && s.charAt(end+1) != ')') {
          end++;
        }
        int cur = Integer.parseInt(s.substring(start, end+1));
        TreeNode node = new TreeNode(cur);
        if (!stack.isEmpty()) {
          TreeNode parent = stack.peek();
          if (parent.left == null) {
            parent.left = node;
          } else {
            parent.right = node;
          }
        }
        stack.push(node);
      }
      end++;
    }
    return stack.isEmpty() ? null :stack.peek();
  }
}
