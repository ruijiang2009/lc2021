package com.myrj.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 * */
public class Question1477 {
  /**
   * Find all the sub arrays
   * Then find the 2 with min sum
   * */
  public int minSumOfLengths(int[] arr, int target) {
    int start = 0;
    int end = 0;
    int sum = 0;
    int[] best = new int[arr.length]; // record the min length of subarray ends on index i.
    Arrays.fill(best, Integer.MAX_VALUE);
    int result = Integer.MAX_VALUE;
    int bestForNow = Integer.MAX_VALUE;
    for(int i = 0; i < arr.length; i++) {
      sum += arr[end];
      while(sum > target) {
        sum -= arr[start];
        start++;
      }
      if (sum == target) {
        if (start > 0 && best[start-1] != Integer.MAX_VALUE) {
          result = Math.min(result, best[start - 1] + i - start + 1);
        }
        // bestForNow records the shortest subarray length
        bestForNow = Math.min(bestForNow, i - start + 1); // i-start+1 is the subarray length which begins with start
      }
      best[i] = bestForNow;
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
