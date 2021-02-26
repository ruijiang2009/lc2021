package com.myrj.app.medium;

public class Question198 {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int n = nums.length;
    int max = 0;
    int[] results = new int[n];
    results[0] = nums[0];
    for(int i = 1; i < n; i++) {
      if (i == 1) {
        results[i] = Math.max(nums[i], results[0]);
      } else {
        results[i] = Math.max(results[i - 2] + nums[i], results[i - 1]);
      }
      max = Math.max(max, results[i]);
    }

    return max;
  }
}
