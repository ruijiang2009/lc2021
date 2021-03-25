package com.myrj.app.medium;

import com.myrj.app.model.TreeNode;

import java.util.*;

public class Question1110 {
  HashMap<Integer, TreeNode> treeNodes = new HashMap<>();
  Set<Integer> toBeDelete = new HashSet<>();

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    for(int num : to_delete) {
      toBeDelete.add(num);
    }
    treeNodes.put(root.val, root);
    delNode(root);
    List<TreeNode> result = new ArrayList<>();
    for(Integer key : treeNodes.keySet()) {
      result.add(treeNodes.get(key));
    }
    return result;
  }

  private void delNode(TreeNode root) {
    if (toBeDelete.contains(root.val)) {
      if (treeNodes.containsKey(root.val)) {
        treeNodes.remove(root.val);
      }
      if (root.left != null) {
        treeNodes.put(root.left.val, root.left);
      }
      if (root.right != null) {
        treeNodes.put(root.right.val, root.right);
      }
    }
    if (root.left != null) {
      delNode(root.left);
      if (toBeDelete.contains(root.left.val)) {
        root.left = null;
      }
    }
    if (root.right != null) {
      delNode(root.right);
      if (toBeDelete.contains(root.right.val)) {
        root.right = null;
      }
    }
  }

}
