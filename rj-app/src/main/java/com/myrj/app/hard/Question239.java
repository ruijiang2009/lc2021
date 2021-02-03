package com.myrj.app.hard;

import java.util.ArrayDeque;

public class Question239 {

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || k <= 0) {
      return null;
    }
    if (nums.length < k) {
      return null;
    }
    // arrayDeque store the idx.
    ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
    int max[] = new int[nums.length-k+1];

    for(int i = 0 ; i < nums.length; i++) {
      // check whether need to pop, if the left most is too small
      // arrayDeque has more than K elements
      while(!arrayDeque.isEmpty() && arrayDeque.peek() < i-k+1) {
        arrayDeque.poll();
      }

      // remove smaller elements from right to left
      while(!arrayDeque.isEmpty() && nums[arrayDeque.peekLast()] < nums[i]) {
        arrayDeque.pollLast();
      }
      arrayDeque.add(i);
      if (i >= k - 1) {
        max[i - k + 1] = nums[arrayDeque.peek()];
      }
    }
    return max;
  }
}
