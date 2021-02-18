package com.myrj.app.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question388 {
  class TreeNode {
    public TreeNode(String value) {
      this.value = value;
    }

    String value;
    TreeNode parent = null;
    List<TreeNode> children = new ArrayList<>();
  }

  public int countTab(String str) {
    return str.lastIndexOf('\t') + 1;
  }

  private TreeNode reconstruct(String input) {

    String[] segments = input.split("\n");
    TreeNode root = new TreeNode("");
    TreeNode first = new TreeNode(segments[0]);
    root.children.add(first);
    first.parent = root;
    TreeNode preNode = first;
    String pre = segments[0];
    String cur = null;

    for(int i = 1; i < segments.length; i++ ) {
      cur = segments[i];
      int preTabCount = countTab(pre);
      int curTabCount = countTab(cur);
      String curValue = cur.substring(curTabCount);
      TreeNode curNode = new TreeNode(curValue);

      if (curTabCount == preTabCount) {
        preNode.parent.children.add(curNode);
        curNode.parent = preNode.parent;
      } else if (curTabCount > preTabCount) {
        preNode.children.add(curNode);
        curNode.parent = preNode;
      } else {
        TreeNode parentNode = preNode;
        for(int s = 0; s < preTabCount - curTabCount + 1; s++) {
          parentNode = parentNode.parent;
        }
        parentNode.children.add(curNode);
        curNode.parent = parentNode;
      }

      pre = cur;
      preNode = curNode;
    }
    return root;
  }


  // not solution
  public int lengthLongestPath(String input) {
    if (input == null || input.length() == 0) {
      return 0;
    }
    TreeNode root = reconstruct(input);
    if (root.children.isEmpty()) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<String> path = new LinkedList<>();
    String max = "";
    queue.add(root);
    path.add(root.value);
    while (!queue.isEmpty()){
      TreeNode treeNode = queue.poll();
      String p = path.poll();
      if (p.length() > max.length()) {
        System.out.println(p);
        max = p;
      }
      for(TreeNode c : treeNode.children) {
        queue.add(c);
        path.add(p + '*' + c.value);
      }
    }
    return max.length() - 1;
  }
}
