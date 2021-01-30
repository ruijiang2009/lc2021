package com.myrj.app.medium;

import java.util.Random;

public class Question528 {

  class Solution {
    Random random;
    int[] weighedSums;

    public Solution(int[] w) {
      random = new Random();;
      for(int i = 1; i < w.length; i++) {
        w[i] += w[i-1];
      }
      this.weighedSums = w;
    }

    public int pickIndex() {
      int len = weighedSums.length;
      int idx = random.nextInt(weighedSums[len-1]) + 1;
      int left = 0;
      int right = len - 1;
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (weighedSums[mid] == idx) {
          return mid;
        } else if (weighedSums[mid] < idx) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
      return left;
    }
  }

}
