package com.myrj.app.hard;

// burst balloon
public class Question312 {

  public int maxCoins(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int length = nums.length;

    int[] newNums = new int[length + 2];
    newNums[0] = 1;
    newNums[length+1] = 1;
    for(int i = 0; i < length; i++) {
      newNums[i+1] = nums[i];
    }

    // opt[i][j] means the balloon range [i j] all popped up
    // what is the biggest result.
    int[][] opt = new int[length + 2][length + 2];

    for (int intervalLen = 0; intervalLen <= length; intervalLen++ ) {
      for (int i = 1; i <= length; i++) {
        int j = i + intervalLen;
        if (j <= length) {
          for (int k = i; k <= j; k++) {
            opt[i][j] = Math.max(opt[i][j], newNums[i-1]*newNums[k]*newNums[j+1] + opt[i][k-1]+opt[k+1][j]);
          }
        }
      }
    }

    return opt[1][length];
  }
}
