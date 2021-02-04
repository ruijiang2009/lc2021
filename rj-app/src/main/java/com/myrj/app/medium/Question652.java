package com.myrj.app.medium;

import java.util.*;

public class Question652 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  /**
   * 1. group the leaf node by number
   * 2. for each leaf node, go to their parent, if they are the same, the +1
   * */
  HashMap<Integer, ArrayList<TreeNode>> leafNodes = new HashMap<>();
  HashMap<TreeNode, TreeNode> parents = new HashMap<>();
  List<TreeNode> result = new ArrayList<>();

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    preOrderTraverse(root);

    for(int val : leafNodes.keySet()) {
      if (leafNodes.get(val).size() > 1) {
        result.add(leafNodes.get(val).get(0));
      }
      findDuplicates(leafNodes.get(val));
    }
    return result;
  }

  private void preOrderTraverse(TreeNode root) {
    if (root.left == null && root.right == null) {
      ArrayList<TreeNode> leaves = leafNodes.getOrDefault(root.val, new ArrayList<>());
      leaves.add(root);
      leafNodes.put(root.val, leaves);
      return;
    }
    if (root.left != null) {
      parents.put(root.left, root);
      preOrderTraverse(root.left);
    }
    if (root.right != null) {
      parents.put(root.right, root);
      preOrderTraverse(root.right);
    }
  }

  // all the nodes has the same value
  private void findDuplicates(List<TreeNode> nodes) {
    HashMap<Integer, ArrayList<TreeNode>> leftParentGroups = new HashMap<>();
    HashMap<Integer, ArrayList<TreeNode>> rightParentGroups = new HashMap<>();
    for(TreeNode node : nodes) {
      TreeNode parent = parents.get(node);
      if (parent == null) {
        continue;
      }
      if (parent.left == node) {
        ArrayList<TreeNode> t = leftParentGroups.getOrDefault(parent.val, new ArrayList<>());
        t.add(parent);
        leftParentGroups.put(parent.val, t);
      } else {
        ArrayList<TreeNode> t = rightParentGroups.getOrDefault(parent.val, new ArrayList<>());
        t.add(parent);
        rightParentGroups.put(parent.val, t);
      }
    }
    for(int val : leftParentGroups.keySet()) {
      if (leftParentGroups.get(val).size() > 1) {
        result.add(leftParentGroups.get(val).get(0));
      }
      findDuplicates(leftParentGroups.get(val));
    }
    for(int val : rightParentGroups.keySet()) {
      if (rightParentGroups.get(val).size() > 1) {
        result.add(rightParentGroups.get(val).get(0));
      }
      findDuplicates(rightParentGroups.get(val));
    }
  }
}
