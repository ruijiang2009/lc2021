package com.myrj.app.medium;

import java.util.PriorityQueue;

public class Question1785 {

  public int minElements(int[] nums, int limit, int goal) {
    long sum = 0, diff;
    for (int a : nums)
      sum += a;
    diff = Math.abs(goal - sum);
    return (int)((diff + limit - 1) / limit);
  }
}
